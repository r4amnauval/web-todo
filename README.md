# 🚀 Jakarta EE Enterprise To-Do List

Aplikasi Manajemen Tugas (To-Do List) berbasis Enterprise yang dibangun menggunakan **Spring Boot 3** dan **Java 21**.

Proyek ini dibuat untuk memenuhi tugas mata kuliah **Jakarta EE**, dengan mengintegrasikan **Workflow Engine (Camunda BPM)** untuk menangani siklus hidup setiap tugas secara profesional.

[![Repo](https://img.shields.io/badge/GitHub-Repository-181717?logo=github)](https://github.com/r4amnauval/web-todo)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.8-green)
![Java](https://img.shields.io/badge/Java-21-orange)
![Camunda](https://img.shields.io/badge/BPM-Camunda%207-blue)
![Docker](https://img.shields.io/badge/Cloud-Docker-2496ED)

## 📋 Pemenuhan Syarat Tugas

Aplikasi ini telah memenuhi seluruh spesifikasi teknis yang diminta:

| Syarat Dosen | Implementasi di Proyek |
| :--- | :--- |
| **Spring / Spring Boot** | Framework utama aplikasi (`@SpringBootApplication`). |
| **Hibernate <jdbc>** | Menggunakan **Spring Data JPA** & Hibernate untuk koneksi ke Database H2. |
| **BPM < BPMN to BPEL >** | Integrasi **Camunda Platform 7** menjalankan `todo_process.bpmn` (Standard BPMN 2.0). |
| **API JAVA** | Backend Logic menggunakan `@RestController` dan Java Service. |
| **REST & / JSON** | Komunikasi data Frontend-Backend menggunakan REST API dengan format JSON. |
| **CLOUD** | Aplikasi *Containerized* menggunakan **Docker** dan siap deploy (Render/HuggingFace). |

---

## 🛠️ Teknologi

* **Bahasa:** Java 21 LTS
* **Framework:** Spring Boot 3.5.8
* **Database:** H2 Database (Embedded / In-Memory)
* **BPM Engine:** Camunda 7.20
* **Frontend:** HTML5, CSS3, JavaScript (Fetch API)
* **Build Tool:** Maven

---

## 🏗️ Alur Kerja Sistem (BPMN)

Setiap tugas (Todo) yang dibuat tidak hanya disimpan ke database, tetapi juga memicu sebuah **Process Instance** di mesin Camunda.

1.  **Start:** User input tugas -> Sistem memulai proses.
2.  **User Task:** Tugas masuk ke status "Kerjakan Tugas" (dilacak oleh Camunda).
3.  **End:** User menceklis selesai -> Proses diakhiri dan dicatat dalam *History*.

---

## 🚀 Cara Menjalankan (Localhost)

Pastikan **Java 21** dan **Maven** sudah terinstall.

1.  **Clone Repository**
    ```bash
    git clone [https://github.com/r4amnauval/web-todo.git](https://github.com/r4amnauval/web-todo.git)
    cd web-todo
    ```

2.  **Jalankan Aplikasi**
    ```bash
    mvn spring-boot:run
    ```

3.  **Akses Aplikasi**
    * 📝 **Web To-Do List:** [http://localhost:8080/index.html](http://localhost:8080/index.html)
    * ⚙️ **BPM Dashboard (Camunda):** [http://localhost:8080/camunda](http://localhost:8080/camunda)
        * *Username:* `admin`
        * *Password:* `admin`
    * 🗄️ **Database (H2):** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
        * *JDBC URL:* `jdbc:h2:mem:webtododb`

> **Catatan:** Jika dideploy ke Cloud (seperti Hugging Face), port mungkin menyesuaikan menjadi `7860` atau sesuai provider.

---

## ☁️ Deployment (Docker / Cloud)

File `Dockerfile` sudah disertakan untuk deployment ke layanan cloud seperti Render, Railway, atau Hugging Face Spaces.

**Cara Build Docker Image:**
```bash
docker build -t webtodo-app .