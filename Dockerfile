FROM zenika/alpine-maven

WORKDIR /app
COPY . /app

RUN mvn clean package

CMD [ "/bin/sh" ]