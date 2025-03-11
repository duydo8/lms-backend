# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17-jdk-slim

# Cài đặt Maven để build ứng dụng trong container
RUN apt-get update && apt-get install -y maven

# Thiết lập thư mục làm việc cho container
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . .

# Chuyển vào thư mục dự án thực sự chứa pom.xml
WORKDIR /app/lms-service

# Kiểm tra file pom.xml có tồn tại không (DEBUG)
RUN ls -la

# Build ứng dụng bằng Maven
RUN mvn clean package -DskipTests

EXPOSE 5000

# Chạy ứng dụng với JAR vừa build
CMD ["java", "-jar", "target/lms-service-0.0.1-SNAPSHOT.jar"]
