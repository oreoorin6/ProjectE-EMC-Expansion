# ProjectE EMC Expansion

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Minecraft Version](https://img.shields.io/badge/minecraft-1.20.1-green.svg)](https://minecraft.net)
[![Forge Version](https://img.shields.io/badge/forge-47.3.0-orange.svg)](https://files.minecraftforge.net)

Advanced EMC calculation and expansion mod for ProjectE with multi-version support.

## 🚀 Features

- **Multi-Version Support**: Compatible with Minecraft 1.12.2 through 1.21.1
- **Advanced EMC Calculation**: Intelligent EMC value calculation for items without preset values
- **Recipe-Based EMC**: Automatically calculates EMC from crafting recipes
- **Material-Based Calculation**: Fallback system using item materials and rarity
- **Configurable Settings**: Customizable EMC multipliers and calculation options
- **ProjectE Integration**: Seamless integration with ProjectE API

## 📦 Installation

1. **Download** the latest release for your Minecraft version
2. **Install** Minecraft Forge for the corresponding version
3. **Download** and install ProjectE as a dependency
4. **Place** the mod JAR file in your `mods/` folder
5. **Launch** Minecraft and enjoy!

## 🎯 Supported Versions

| Minecraft | Forge | ProjectE | Status |
|-----------|-------|----------|--------|
| 1.21.1    | 52.0.17 | 1.1.0    | ✅ Active |
| 1.20.1    | 47.3.0  | 1.0.1    | ✅ **Current Release** |
| 1.19.2    | 43.3.13 | 1.1.0    | ⚠️ Supported |
| 1.18.2    | 40.2.21 | 1.0.2    | ⚠️ Supported |
| 1.16.5    | 36.2.42 | PE1.0.1B | 📦 Legacy |
| 1.15.2    | 31.2.57 | 1.0.4    | 📦 Legacy |
| 1.12.2    | 14.23.5 | 1.4.1    | 📦 Legacy |

## 🔧 Building from Source

### Prerequisites
- Java 17+ (for MC 1.18+) or Java 8+ (for older versions)
- Git

### Build Instructions

```bash
# Clone the repository
git clone https://github.com/oreoorin6/ProjectE-EMC-Expansion.git
cd ProjectE-EMC-Expansion

# Build the mod (uses Gradle wrapper)
./gradlew build

# On Windows
gradlew.bat build

# Find the built JAR in build/libs/
```

### Development

```bash
# Run Minecraft client for testing
./gradlew runClient

# Run dedicated server
./gradlew runServer

# Generate development workspace for IntelliJ IDEA
./gradlew genIntellijRuns
```

## ⚙️ Configuration

The mod creates a configuration file at `config/projecte_emc_expansion-common.toml`:

```toml
["General Settings"]
    # Enable advanced EMC calculation for items without EMC values
    enableAdvancedEmcCalculation = true
    # Enable recipe scanning for EMC calculation  
    enableRecipeScanning = true
    # Size of EMC calculation cache
    emcCacheSize = 1000
    # Global EMC multiplier for calculated values
    emcMultiplier = 1.0
```

## 📖 Usage

### For Players
- Install the mod alongside ProjectE
- Items without EMC will automatically get calculated values
- Check the configuration file to adjust calculation behavior

### For Developers
- The mod provides compatibility layers for different ProjectE versions
- Version-specific implementations handle API differences
- Extend the EMC calculation system through the provided interfaces

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Make your changes with proper version compatibility
4. Test across supported Minecraft versions
5. Submit a pull request

## 🐛 Issue Reporting

Please report issues on our [GitHub Issues](https://github.com/oreoorin6/ProjectE-EMC-Expansion/issues) page with:
- Minecraft version
- Forge version  
- ProjectE version
- Detailed description and logs

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **ProjectE Team** - For the amazing base mod
- **Minecraft Forge** - For the modding framework
- **Community** - For feedback and suggestions

---

**Made with ❤️ for the Minecraft modding community**