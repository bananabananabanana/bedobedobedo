var gulp = require('gulp'),
    concat = require('gulp-concat'),
    minifyCSS = require('gulp-minify-css'),
    rename = require('gulp-rename'),
    uglify = require('gulp-uglify');

// Scripts
gulp.task('scripts', function() {
    return gulp.src('../_sources/scripts/**/*.js')
        .pipe(concat('app.min.js')) // конкатинация
        .pipe(uglify()) // минификация js
        .pipe(gulp.dest('../scripts')); // сохранение в папку
});

// Style
gulp.task('styles', function () {
    return gulp.src('../_sources/styles/main.css')
        .pipe(minifyCSS()) // минификация css
        .pipe(rename('app.min.css')) // переименование
        .pipe(gulp.dest('../styles')); // сохранение в папку
});

// Default
gulp.task('default', function() {
    gulp.start('styles', 'scripts');

    gulp.watch('../_sources/styles/**', function() {
        gulp.start('styles');
    });

    gulp.watch('../_sources/scripts/**', function() {
        gulp.start('scripts');
    });
});