# Sử dụng OpenJDK 17 để chạy ứng dụng
FROM openjdk:17-jdk-slim

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy file JAR từ thư mục build vào container
COPY lms-service/target/lms-service-0.0.1-SNAPSHOT.jar app.jar

# Chạy ứng dụng
CMD ["java", "-jar", "app.jar"]
