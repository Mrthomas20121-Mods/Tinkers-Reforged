const fs = require('fs');

let fluids = [
	"qivium", 
	"kovar",
	"lavium",
	"ludicrite", 
	"blutonium", 
	"infused_iron", 
	"sky",
	"starmetal", 
	"refined_obsidian",
	"refined_glowstone",
	"osmium",
	"ventium",
	"horizonite",
	"pyrope",
	"black_quartz",
	"enori",
	"void_crystal",
	"zinc",
	"emeradic",
	"diamantine",
	"palis",
	"redstonia"
];

for(fluid of fluids) {
console.log(`fluid.${fluid}.name=Molten ${fluid}`)
let data = {
	 "forge_marker": 1,
	 "defaults": {
	  "model": "forge:fluid"
	 },
	 "variants": {
	  "normal": [
			{
			    "custom": {
				    "fluid": fluid
				 }
			}
		]
	}
}

fs.writeFileSync(`./src/main/resources/assets/tinkers_reforged/blockstates/molten_${fluid}.json`, JSON.stringify(data, null, 2), 'utf8')
}