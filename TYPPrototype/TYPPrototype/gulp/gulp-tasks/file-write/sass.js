var fs = require('fs');

module.exports = function(gulp, callback) {
   if(material == 'material-'){
      return fs.writeFile(config.source.sass + '/core/variables/variables.scss', "@import \"_material-variables\";", callback);
   }else{
      return fs.writeFile(config.source.sass + '/core/variables/variables.scss', "@import \"_bootstrap-variables\";", callback);
   }
};