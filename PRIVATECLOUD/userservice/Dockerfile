#FROM openjdk:8
#EXPOSE 8080
#ADD target/userservice.jar userservice.jar
#ENTRYPOINT [ "java","-jar","/userservice.jar/" ]

FROM openjdk:17
ARG nameFILE=target/*.jar
COPY ./target/userservice.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]


FROM container-registry.oracle.com/mysql/community-server:8.4
ENV MYSQL_ROOT_PASSWORD=KingsClub@123
ENV MYSQL_DATABASE=privatecloud
EXPOSE 3306
VOLUME /var/lib/mysql
CMD ["mysqld_safe"]

