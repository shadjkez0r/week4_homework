# 🧵 Java Concurrency & Multithreading Playground

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Concurrency](https://img.shields.io/badge/Topic-Multithreading%20%2F%20Locks-blue?style=for-the-badge)

Учебный и исследовательский проект (Week 4 Homework), посвященный глубокому изучению многопоточности в Java, синхронизации потоков, межпоточному взаимодействию и моделированию классических проблем конкурентного доступа к разделяемым ресурсам.

---

## 📚 Исследуемые концепции и структура проекта

Проект разбит на три изолированных модуля, каждый из которых наглядно моделирует и решает конкретную архитектурную или алгоритмическую задачу многопоточного программирования:

```text
src/main/java/evg/megatron/
├── deadlock/   # Моделирование классической взаимной блокировки (Deadlock)
├── livelock/   # Моделирование активной блокировки (Livelock)
└── pingpong/   # Строгая последовательная синхронизация потоков (Ping-Pong)
