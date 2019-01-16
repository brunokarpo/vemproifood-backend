package nom.brunokarpo.weatherplaylist.configuration

import org.postgresql.ds.PGPoolingDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Profile
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextStoppedEvent
import org.springframework.context.event.EventListener
import ru.yandex.qatools.embed.postgresql.PostgresProcess
import ru.yandex.qatools.embed.postgresql.PostgresStarter
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig
import java.io.IOException
import javax.sql.DataSource

@Profile("test")
@Configuration
class EmbeddedPostgresConfiguration(
        @Value("\${spring.embedded-postgres.port:5433}")
        private var port: Int,

        @Value("\${spring.embedded-postgres.database:postgres_test}")
        private var database: String,

        @Value("\${spring.embedded-postgres.username:postgre-user-test}")
        private var username: String,

        @Value("\${spring.embedded-postgres.password:postgre-passwd-test}")
        private var password: String,

        @Value("\${spring.embedded-postgres.data-dir:target}")
        private var dataDir: String
) {

    private var globalPostgresInstance: PostgresProcess? = null

    @Bean(destroyMethod = "stop")
    @Throws(IOException::class)
    fun postgresProcess(): PostgresProcess {
        val postgresConfig = PostgresConfig.defaultWithDbName(database, username, password)

        var runtime = PostgresStarter.getDefaultInstance()
        var exec = runtime.prepare(postgresConfig)
        globalPostgresInstance = exec.start()

        return globalPostgresInstance!!
    }


    @Bean(destroyMethod = "close")
    @DependsOn("postgresProcess")
    fun dataSource(postgresProcess: PostgresProcess): DataSource {
        var dataSource = PGPoolingDataSource()

        var postgresConfig = postgresProcess.config
        dataSource.user = postgresConfig.credentials().username()
        dataSource.password = postgresConfig.credentials().password()
        dataSource.portNumber = postgresConfig.net().port()
        dataSource.serverName = postgresConfig.net().host()
        dataSource.databaseName = postgresConfig.storage().dbName()

        return dataSource
    }

    @EventListener(ContextStoppedEvent::class, ContextClosedEvent::class)
    fun tearDown() {
        if (globalPostgresInstance != null) {
            globalPostgresInstance!!.stop()
        }
    }

}