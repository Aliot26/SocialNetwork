exports.config = {
    baseUrl: 'http://localhost:8080/',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    capabilities: {
        'browserName': 'chrome'
    },
    framework: 'jasmine',
    jasmineNodeOpts: {
        defaultTimeoutInterval: 30000
    },
    allScriptsTimeout: 110000,
    specs: ['authorization/loginjs.e2e.js'],

    onPrepare: function () {
        var jasmineReporters = require('jasmine-reporters');
        jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
                consolidateAll: true,
                savePath: 'testReportsWithPageObject',
                filePrefix: 'ReportPageObject'
            })
        );
    }

    //webdriver-manager start --standalone
};