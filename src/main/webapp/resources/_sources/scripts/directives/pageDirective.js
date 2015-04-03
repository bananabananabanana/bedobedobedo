/**
 * @ngdoc directive
 * @name page
 * @restrict E
 */
pageDirective.$inject = [];
function pageDirective() {
    return {
        restrict: 'E',
        scope: {
            name: '@'
        },
        link: link
    };

    function link(scope, element) {
        element.html('Page: ' + scope.name);
    }
}