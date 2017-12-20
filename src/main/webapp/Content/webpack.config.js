module.exports = {
    entry: {
        index: "./js/index.js",
        login: "./js/login.js"
    },

    output: {
        path: __dirname + "/built/",
        publicPath: "/Content/built/",
        filename: "[name].bundle.js",
        // chunkFilename: "/branch/[name].chunk.js",
    },

    resolve: {
        extensions: ['*', '.js', '.jsx']
    },

    node: {
        fs: "empty",
        child_process: "empty"
    },
    module: {
        loaders: [
            {test: /\.css$/, loader: "style-loader!css-loader"},
            {test: /\.less$/, loader: "style-loader!css-loader!less-loader"},
            {test: /\.(png|jpg)$/, loader: 'url-loader?limit=10000'},
            {test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=application/font-woff'},
            {test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=application/octet-stream'},
            {test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, loader: 'file'},
            {test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=image/svg+xml'}
        ],
        rules: [
            {
                test: /\.(js|jsx$)/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader?cacheDirectory',
                    query: {
                        presets: [
                            'babel-preset-stage-2',
                            'babel-preset-es2015',
                            'babel-preset-react'
                        ].map(require.resolve)}

                }
            }

        ]

    }

};