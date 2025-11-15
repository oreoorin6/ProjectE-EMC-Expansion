# ProjectE EMC Expansion v1.0.0 Release Notes

## 🎉 Initial Release - Minecraft 1.20.1

### ✨ Features
- **Core EMC Expansion System**: Automatically detects and integrates with ProjectE
- **Multi-Version Framework**: Built with support for Minecraft 1.12.2 through 1.21.1
- **Configuration System**: Customizable EMC calculation settings via Forge Config
- **Reflection-Based Safety**: Safe ProjectE API access across different versions
- **Performance Optimized**: Efficient runtime ProjectE detection and integration

### 🎯 Current Release Target
- **Minecraft**: 1.20.1
- **Forge**: 47.3.0+
- **ProjectE**: 1.0.1+ (PE1.0.1)
- **Java**: 17+

### 📦 Installation
1. Download `projecte-emc-expansion-1.0.0-mc1.20.1.jar`
2. Install Minecraft Forge 47.3.0 or later for MC 1.20.1
3. Install ProjectE PE1.0.1 or compatible version
4. Place both JAR files in your `mods/` folder
5. Launch Minecraft and enjoy enhanced EMC functionality!

### ⚙️ Configuration Options
The mod creates `config/projecte_emc_expansion-common.toml` with these settings:
- `enableAdvancedEmcCalculation`: Enable advanced EMC calculation (default: true)
- `enableRecipeScanning`: Enable recipe scanning for EMC (default: true)
- `emcCacheSize`: EMC calculation cache size (default: 1000)
- `emcMultiplier`: Global EMC value multiplier (default: 1.0)

### 🔧 Development
This release includes the foundation for multi-version support:
- Version-specific source directories for each Minecraft version
- Automated build system with version profiles
- GitHub Actions CI/CD for multi-version building
- Comprehensive documentation and setup guides

### 🐛 Known Issues
- None reported for this initial release
- Please report issues on GitHub with your setup details

### 🚀 Upcoming Features
- Advanced recipe chain EMC calculation
- Custom EMC assignment commands
- Integration with JEI/REI for EMC value display
- Additional Minecraft version releases (1.21.1, 1.19.2, etc.)

---

**Compatibility Verified With:**
- ProjectE PE1.0.1 for MC 1.20.1
- Forge 47.3.0 and 47.4.8
- Java 17 and Java 21
- Various popular modpacks

**Download the JAR file from the releases section and start expanding your EMC system today!**