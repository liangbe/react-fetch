
module.exports = {
    entry: {
        index: "./js/index.js",
        login: "./js/login.js"
    },

    output: {
        path: __dirname + "/built/",
        publicPath: "/Content/built/",
        filename: "[name].bundle.js",
        chunkFilename: "/branch/[name].chunk.js",
    },

    resolve: {
        extensions: ['', '.js', '.jsx']
    },

    node: {
        fs: "empty",
        child_process: "empty"
    },
    module: {
        loaders: [
            {test: /\.css$/, loader: "style!css"},
            {test: /\.less$/, loader: "style!css!less"},
            {test: /\.(png|jpg)$/, loader: 'url-loader?limit=10000'},
            {test: /\.(js|jsx$)/, exclude: /(node_modules|bower_components)/, loader: 'babel?cacheDirectory'},
            {test: require.resolve("jquery"), loader: "expose?$!expose?jQuery"},
            {test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=application/font-woff'},
            {test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=application/octet-stream'},
            {test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, loader: 'file'},
            {test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, loader: 'url?limit=10000&mimetype=image/svg+xml'}
        ]
    }

};