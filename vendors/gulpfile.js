var gulp = require('gulp');
var connect = require('gulp-connect');

var concat = require('gulp-concat');
var directorySync = require('gulp-directory-sync');
var minifyHTML = require('gulp-minify-html');
var minifyCSS = require('gulp-minify-css');
var rename = require('gulp-rename');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');

// Файлы для обработки
var files = {
    images: '/**/*',
    scripts: '/**/*.js',
    styles: '/main.css',
    templates: '/**/*.html'
};

// Папки исходников
var sources = {
    images: '../sources/images',
    scripts: '../sources/scripts',
    styles: '../sources/styles',
    templates: '../sources/templates'
};

// Папки назначения
var www = {
    application: '../www/application',
    images: '../www/images',
    fonts: '../www/fonts',
    libraries: '../www/libraries',
    templates: '../www/templates'
};

// Vendors
var vendors = {
    fonts: [
        '../vendors/bower_components/ionic/release/fonts/**'
    ],
    scripts: [
        '../vendors/bower_components/angular/angular.js',
        '../vendors/bower_components/angular-animate/angular-animate.js',
        '../vendors/bower_components/angular-route/angular-ui-route.js',
        '../vendors/bower_components/angular-sanitize/angular-sanitize.js',
        '../vendors/bower_components/ionic/release/js/ionic.bundle.js',
        '../vendors/bower_components/ionic/release/js/ionic.js',
        '../vendors/bower_components/ionic/release/js/ionic-angular.js'
    ],
    styles: [
        '../vendors/bower_components/ionic/release/css/ionic.css'
    ]
};

// Сервер и отслеживание изменений
gulp.task('default', ['library', 'image', 'script', 'style', 'template'], function () {
    connect.server({
        root: '../www',
        port: 3000,
        host: '127.0.0.1',
        fallback: '../www/index.html',
        livereload: true
    });

    gulp.watch(sources.images + files.images, ['image']);
    gulp.watch(sources.scripts + files.scripts, ['script']);
    gulp.watch(sources.styles + files.styles, ['style']);
    gulp.watch(sources.templates + files.templates, ['template']);
});

// Картинки
gulp.task('image', function () {
    gulp.src(sources.images + files.images) // исходники
        .pipe(gulp.dest(www.images)) // сохранение
        .pipe(connect.reload()) // обновление
        .pipe(directorySync(sources.images, www.images)); // синхронизация
});

// Библиотеки
gulp.task('library', function () {
    // Шрифты
    gulp.src(vendors.fonts)
        .pipe(gulp.dest(www.fonts));

    // Скрипты
    gulp.src(vendors.scripts) // исходники
        .pipe(sourcemaps.init()) // инициализация карт
        .pipe(concat('lib.min.js')) // конкатенация
        .pipe(uglify()) // минификация
        .pipe(sourcemaps.write()) // запись карт
        .pipe(gulp.dest(www.libraries)); // сохранение

    // Стили
    gulp.src(vendors.styles) // исходники
        .pipe(sourcemaps.init()) // инициализация карт
        .pipe(concat('lib.min.css')) // конкатенация
        .pipe(minifyCSS()) // минификация
        .pipe(sourcemaps.write()) // запись карт
        .pipe(gulp.dest(www.libraries)); // сохранение
});

// Скрипты
gulp.task('script', function () {
    gulp.src(sources.scripts + files.scripts) // исходники
        .pipe(sourcemaps.init()) // инициализация карт
        .pipe(concat('app.min.js')) // конкатенация
        .pipe(uglify()) // минификация
        .pipe(sourcemaps.write()) // запись карт
        .pipe(gulp.dest(www.application)) // сохранение
        .pipe(connect.reload()); // обновление
});

// Стили
gulp.task('style', function () {
    gulp.src(sources.styles + files.styles) // исходники
        .pipe(sourcemaps.init()) // инициализация карт
        .pipe(minifyCSS()) // минификация
        .pipe(rename('app.min.css')) // переименование
        .pipe(sourcemaps.write()) // запись карт
        .pipe(gulp.dest(www.application)) // сохранение
        .pipe(connect.reload()); // обновление
});

// Шаблоны
gulp.task('template', function () {
    gulp.src(sources.templates + files.templates) // исходники
        .pipe(minifyHTML()) // минификация
        .pipe(gulp.dest(www.templates)) // сохранение
        .pipe(connect.reload()) // обновление
        .pipe(directorySync(sources.templates, www.templates)); // синхронизация
});