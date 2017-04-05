exports.config = {

    baseUrl: 'http://localhost:3000/',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    capabilities: {
        'browserName': 'chrome'
    },
    framework: 'jasmine',
    jasmineNodeOpts: {
        defaultTimeoutInterval: 30000
    },
    allScriptsTimeout: 110000,
    specs: ['src/**/**.e2e.ts'],

    onPrepare: function () {
        var jasmineReporters = require('jasmine-spec-reporter');
        jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
                consolidateAll: true,
                savePath: 'testReportsWithPageObject',
                filePrefix: 'ReportPageObject'
            })
        );
    }

};