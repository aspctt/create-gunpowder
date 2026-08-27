# <p align=center> Create: Gunpowder </p>

![Version](https://img.shields.io/badge/Available_for-1.21.1-blue)
![Mod Loader](https://img.shields.io/badge/Mod_Loader-NeoForge-orange)
![Requires](https://img.shields.io/badge/Requires-Create_6.0.x-blueviolet)
![License](https://img.shields.io/badge/License-All_Rights_Reserved-red)

## Description

Create: Gunpowder adds production chains to produce gunpowder, mainly for modpacks or worlds where creepers don’t exist or drop it. Instead of mob farms, gunpowder becomes a processed resource that fits naturally into Create’s progression.

The chain runs through the mechanical press, the millstone, and the mixer, and ends in a heated mix:

* Press Flint --> Flint Shard
* Mill Coal or Charcoal --> 2x Carbon Dust
* Mill Sand or Sandstone --> 2x Mineral Dust
* Mix Flint Shard + Carbon Dust --> Volatile Powder
* Mix Volatile Powder + Mineral Dust + Water + Heat --> 2x Gunpowder

![Recipe Path](https://cdn.modrinth.com/data/cached_images/d6c9891031b95f3a67822b1bd91b00e74c499e22.png)

Every step is a generated datapack recipe, so a pack can retune, extend, or remove any of them. Version history is in [CHANGE_LOG.md](./CHANGE_LOG.md), and the text used on the mod pages is in [DESCRIPTION.md](./DESCRIPTION.md).

## Installation

Place the jar in the mods folder of your Minecraft instance, alongside NeoForge and Create.

**REMOVE ANY OLD VERSIONS BEFORE INSTALLING**.

## Dependencies

* Minecraft 1.21.1
* NeoForge 21.1.217 or newer
* Create 6.0.9 or newer, below 6.1.0

## Building

Clone the repository and run `gradlew build`. The jar is written to `build/libs`. `gradlew runClient` launches a development instance, and `gradlew runData` regenerates the recipes, tags, and item models under `src/generated`.

## Licensing

Create: Gunpowder is **All Rights Reserved**. The full terms are in [LICENSE](./LICENSE). The short version:

* You may download it and play with it.
* **Pack content is yours.** Datapacks, resource packs, KubeJS or CraftTweaker scripts, and configs that add to, rebalance, override, or switch off the recipes are yours to create for any purpose including commercial ones, and to distribute and sell on any terms you choose. The project claims no ownership over your work, requires no attribution, and this grant is irrevocable: it cannot be withdrawn from pack content already published, and it survives any future change to the licence.
* Separate mods, tools, editors, and validators that interoperate through the registry entries and recipe definitions are equally permitted.
* Modpacks may include the mod **by reference**, the way a CurseForge manifest or a Modrinth index does, so the launcher fetches it from an official page. Re-hosting, bundling, or altering the JAR is not permitted.
* The mod's own source code and assets stay reserved.

Version 1.0.0 shipped with its licence field set to MIT, and 1.0.1 under GPL-3.0-or-later. Those builds stay available under those terms to anyone who already has them. The terms above cover every release from 1.0.2 onward.

Please note the copyrights and trademarks in [NOTICE](./NOTICE).

## Credits

### Core Team

* aspctt - code, recipes, textures, project lead

### Built against

* The Create Team - [Create](https://github.com/Creators-of-Create/Create), whose press, millstone, and mixer this mod’s recipes run on
* NeoForged - [NeoForge](https://github.com/neoforged/NeoForge), and the MDK this project started from
* mezz - [Just Enough Items](https://github.com/mezz/JustEnoughItems), used in the development environment
