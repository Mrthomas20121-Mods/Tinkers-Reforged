const fs = require('fs');

let fluids = [
    { name: 'proto_lava', type: 'lava' },
    { name: 'blazium', type: 'metal' },
    { name: 'bomin', type: 'metal' },
    { name: 'duralumin', type: 'metal' },
    { name: 'durasteel', type: 'metal' },
    { name: 'electric_copper', type: 'metal' },
    { name: 'epidote', type: 'gem' },
    { name: 'etryx', type: 'metal' },
    { name: 'ferobolt', type: 'metal' },
    { name: 'gallium', type: 'metal' },
    { name: 'hornium', type: 'metal' },
    { name: 'hureaulite', type: 'gem' },
    { name: 'kepu', type: 'metal' },
    { name: 'lavium', type: 'metal' },
    { name: 'mosite', type: 'metal' },
    { name: 'qivium', type: 'metal' },
    { name: 'red_beryl', type: 'gem' },
    { name: 'tiberium', type: 'metal' },
    { name: 'titanium', type: 'metal' }
]

let lavaStill = {
    "animation": {}
};

let defaultJson = {
    "animation": {
      "frametime": 2
    }
};
  

for(let fluid of fluids) {
    let name = fluid.name

    fs.writeFileSync(`./fluid/${name}/flowing.png.mcmeta`, JSON.stringify(defaultJson, null, 2));
    if(fluid.type == 'lava') {
        fs.writeFileSync(`./fluid/${name}/still.png.mcmeta`, JSON.stringify(lavaStill, null, 2));
    }
    else {
        fs.writeFileSync(`./fluid/${name}/still.png.mcmeta`, JSON.stringify(defaultJson, null, 2));
    }
}