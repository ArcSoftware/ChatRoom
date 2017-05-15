/**
 *  run 'gulp watch' to run default tasks and watch files
 * 
 * - convert sass to css
 * - bundle js modules (browserify)
 * - strip js comments
 */

let gulp = require('gulp');
let sass = require('gulp-sass');
let browser = require('gulp-browser');

let OUTPUT_DIRECTORY = 'public';

gulp.task('default', ['html', 'css', 'js']);

gulp.task('html', function() {
  return gulp.src('../templates/index.html')
             .pipe(gulp.dest(OUTPUT_DIRECTORY)); 
});

gulp.task('chat', function() {
  return gulp.src('../templates/chat.html')
             .pipe(gulp.dest(OUTPUT_DIRECTORY)); 
});

gulp.task('css', function() {
  return gulp.src('scss/style.scss')
             .pipe(sass())
             .pipe(gulp.dest(OUTPUT_DIRECTORY));
});

gulp.task('js', function() {
  return gulp.src('js/app.js')
            //  .pipe(browser.browserify())
             .pipe(gulp.dest(OUTPUT_DIRECTORY));
});

gulp.task('watch', ['html', 'css', 'js'], function() {
  gulp.watch('index.html', ['html']);
  gulp.watch('scss/*.scss', ['css']);
  gulp.watch('js/*.js', ['js']);
});