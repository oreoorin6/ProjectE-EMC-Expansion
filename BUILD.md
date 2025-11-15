# Building ProjectE EMC Expansion

## Prerequisites
- Java 17+ for MC 1.20.1
- Git

## Quick Build
```bash
# Clone repository
git clone https://github.com/oreoorin6/ProjectE-EMC-Expansion.git
cd ProjectE-EMC-Expansion

# Build mod
./gradlew build

# Find JAR in build/libs/
```

## Supported Versions
| Minecraft | Forge | ProjectE | Java |
|-----------|-------|----------|------|
| 1.21.1 | 52.0.17 | 1.1.0 | 21 |
| 1.20.1 | 47.3.0 | 1.0.1 | 17 |
| 1.19.2 | 43.3.13 | 1.1.0 | 17 |
| 1.18.2 | 40.2.21 | 1.0.2 | 17 |
| 1.16.5 | 36.2.42 | PE1.0.1B | 8 |
| 1.15.2 | 31.2.57 | 1.0.4 | 8 |
| 1.12.2 | 14.23.5 | 1.4.1 | 8 |

## Development
```bash
# Run client for testing
./gradlew runClient

# Run server
./gradlew runServer
```