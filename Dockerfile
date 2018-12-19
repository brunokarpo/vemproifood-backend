FROM brunokarpo/openjdk-8
LABEL maintainer="Bruno Nogueira <ti.brunonogueira at gmail.com>"
RUN mkdir -p /app/
ADD build/libs/*.jar /app/weather-playlist.jar
ENTRYPOINT ["java", "-jar", "/app/weather-playlist.jar"]