# --- Tahap 1: Membangun (Build) ---
# Kita pinjam image Maven yang sudah ada Java 21-nya
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy semua file project kita ke dalam image
COPY . .

# Perintah untuk membuat file .jar (Skip test biar cepat)
RUN mvn clean package -DskipTests

# --- Tahap 2: Menjalankan (Run) ---
# Kita pindahkan file .jar jadi ke image yang lebih ringan
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp

# Ambil file jar dari Tahap 1
COPY --from=build /app/target/*.jar app.jar

# Perintah untuk menyalakan aplikasi saat deploy selesai
ENTRYPOINT ["java","-jar","/app.jar"]