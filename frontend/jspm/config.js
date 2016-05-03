System.config({
  baseURL: "/",
  defaultJSExtensions: true,
  transpiler: "typescript",
  paths: {
    "npm:*": "jspm_packages/npm/*",
    "github:*": "jspm_packages/github/*"
  },
  separateCSS: true,

  packages: {
    "src": {
      "defaultExtension": "js"
    }
  },

  map: {
    "angular2": "npm:angular2@2.0.0-beta.17",
    "bootstrap": "github:twbs/bootstrap@3.3.6",
    "css": "github:systemjs/plugin-css@0.1.21",
    "debug": "src/debug",
    "jquery": "npm:jquery@2.2.3",
    "typescript": "npm:typescript@1.8.10",
    "github:jspm/nodelibs-os@0.1.0": {
      "os-browserify": "npm:os-browserify@0.1.2"
    },
    "github:twbs/bootstrap@3.3.6": {
      "jquery": "npm:jquery@2.2.3"
    },
    "npm:angular2@2.0.0-beta.17": {
      "reflect-metadata": "npm:reflect-metadata@0.1.2",
      "rxjs": "npm:rxjs@5.0.0-beta.7",
      "zone.js": "npm:zone.js@0.6.12"
    },
    "npm:os-browserify@0.1.2": {
      "os": "github:jspm/nodelibs-os@0.1.0"
    },
    "npm:rxjs@5.0.0-beta.7": {
      "symbol-observable": "npm:symbol-observable@0.2.4"
    },
    "npm:typescript@1.8.10": {
      "os": "github:jspm/nodelibs-os@0.1.0"
    }
  }
});
