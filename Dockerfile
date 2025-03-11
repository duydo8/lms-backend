# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17-jdk-slim

# Cài đặt Maven để build source code trực tiếp trong container
RUN apt-get update && apt-get install -y maven

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng bằng Maven (không cần build trước trên máy)
RUN mvn clean package -DskipTests

# Chạy ứng dụng với JAR vừa build
CMD ["java", "-jar", "target/lms-service-0.0.1-SNAPSHOT.jar"]
