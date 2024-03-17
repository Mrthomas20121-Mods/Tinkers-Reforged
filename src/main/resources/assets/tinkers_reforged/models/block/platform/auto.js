const fs = require('fs');
const path = require('path');

let types = ['both', 'bottom', 'neither', 'side', 'top']

// {"render_type": "cutout"}
for(let folder of fs.readdirSync('.')) {
    if(folder == 'auto.js') return;
    for(let type of types) {
        let dir = path.join('.', folder, type+'.json');
        let json = JSON.parse(fs.readFileSync(dir, 'utf8'));
        json.render_type = 'cutout';
        fs.writeFileSync(dir, JSON.stringify(json, null, 2), 'utf8');
    }
}