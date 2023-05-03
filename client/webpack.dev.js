const merger = require('webpack-merge');

const { paths, webpackConfig } = require('./webpack.common.js');

module.exports = merger.merge(webpackConfig, {
  mode: 'development',

  devtool: 'inline-source-map',

  devServer: {
    port: 3000,
    static: paths.public,
    historyApiFallback: true,
    compress: true,
    open: true
  },

  module: {
    rules: [
      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          'style-loader',
          {
            loader: 'css-loader',
            options: {
              importLoaders: 1,
              modules: {
                localIdentName: '[name]__[local]___[hash:base64:5]',
              },
            },
          },
          "sass-loader",
        ],
      }
    ],
  },
});
