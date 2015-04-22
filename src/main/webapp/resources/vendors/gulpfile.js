var gulp = require("gulp");
var gulpClean = require("gulp-clean");
var gulpConcat = require("gulp-concat");
var gulpMinifyCSS = require("gulp-minify-css");
var gulpRename = require("gulp-rename");
var gulpSourcemaps = require("gulp-sourcemaps");
var gulpUglify = require("gulp-uglify");

var sources = {
    scripts: "../sources/scripts/**/*.js",
    styles: "../sources/styles/main.css"
};

var vendors = {
    scripts: [
        "../vendors/bower_components/angular/angular.js",
        "../vendors/bower_components/angular-animate/angular-animate.js",
        "../vendors/bower_components/angular-route/angular-route.js",
        "../vendors/bower_components/angular-touch/angular-touch.js"
    ]
};

var www = {
    application: "../www/application",
    libraries: "../www/libraries"
};

gulp.task("library", function () {
    gulp.src(www.libraries + "/*", {read: false})
        .pipe(gulpClean({force: true}));

    gulp.src(vendors.scripts)
        .pipe(gulpSourcemaps.init())
        .pipe(gulpConcat("lib.min.js"))
        .pipe(gulpUglify())
        .pipe(gulpSourcemaps.write())
        .pipe(gulp.dest(www.libraries));
});

gulp.task("script", function () {
    gulp.src(www.application + "/app.min.js")
        .pipe(gulpClean({force: true}));

    gulp.src(sources.scripts)
        .pipe(gulpSourcemaps.init())
        .pipe(gulpConcat("app.min.js"))
        .pipe(gulpUglify())
        .pipe(gulpSourcemaps.write())
        .pipe(gulp.dest(www.application));

    gulp.watch(sources.scripts, function () {
        gulp.start("script");
    });
});

gulp.task("style", function () {
    gulp.src(www.application + "/app.min.css")
        .pipe(gulpClean({force: true}));

    gulp.src(sources.styles)
        .pipe(gulpSourcemaps.init())
        .pipe(gulpMinifyCSS())
        .pipe(gulpRename("app.min.css"))
        .pipe(gulpSourcemaps.write())
        .pipe(gulp.dest(www.application));

    gulp.watch(sources.styles, function () {
        gulp.start("style");
    });
});

gulp.task("default", ["library", "script", "style"]);