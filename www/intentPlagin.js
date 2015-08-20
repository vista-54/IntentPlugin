/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function IntentPlugin() {
};
if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.intentPlugin) {
    window.plugins.intentPlugin = new IntentPlugin();
}
IntentPlugin.prototype.startScan = function(url) {
    cordova.exec(successCallback, errorCallback, "IntentPlugin", "startScan", [url]);
};

module.exports = IntentPlugin;
