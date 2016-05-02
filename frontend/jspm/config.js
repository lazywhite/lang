System.config({
  baseURL: "/",
  defaultJSExtensions: true,
  transpiler: 'typescript',
  paths: {
    "npm:*": "jspm_packages/npm/*",
    "github:*": "jspm_packages/github/*"
  },
  separateCSS: true,
  packages: {
     src: {
        defaultExtension: 'js'
  }
  },
  map: {
    "bootstrap": "github:twbs/bootstrap@3.3.6",
    "css": "github:systemjs/plugin-css@0.1.21",
    "jquery": "npm:jquery@2.2.3",
    "typescript": "npm:typescript@1.8.10",
    "debug": "src/debug",
    "github:jspm/nodelibs-os@0.1.0": {
      "os-browserify": "npm:os-browserify@0.1.2"
    },
    "github:twbs/bootstrap@3.3.6": {
      "jquery": "npm:jquery@2.2.3"
    },
    "npm:os-browserify@0.1.2": {
      "os": "github:jspm/nodelibs-os@0.1.0"
    },
    "npm:typescript@1.8.10": {
      "os": "github:jspm/nodelibs-os@0.1.0"
    }
  }
});
