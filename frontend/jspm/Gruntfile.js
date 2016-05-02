module.exports = function(grunt){
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        // ...
        jspm: {
            monolithicBundle: {
                options: {
                    sfx: true,
                    minify: true,
                    mangle: true,
                    sourceMaps: false
                },
                files: {
                    "build/js/app.js": "src/app.js"
                }
            }
        },
        sass: {
            dist: {
                files: [{
                    expand: true,
                    cwd: 'src/sass',
                    src: ['*.scss'],
                    dest: '../../build/css',
                    ext: '.css'
                }]
            }
        },

    });
    grunt.loadNpmTasks('grunt-jspm-builder');
    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.registerTask('default', ['jspm', 'sass']);

}
