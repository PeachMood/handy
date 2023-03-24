const path = require('path');
const merger = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const common = require('./webpack.common.js');

const SRC_PATH = path.resolve(__dirname, './src');
const BUILD_PATH = path.resolve(__dirname, './build');
const PUBLIC_PATH = path.resolve(__dirname, './public')

module.exports = merger.merge(common, {
  mode: 'development',

  devtool: 'inline-source-map',

  entry: SRC_PATH + '/index.dev.tsx',

  output: {
    path: BUILD_PATH,
    filename: 'bundle.js',
  },

  devServer: {
    static: PUBLIC_PATH,
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

  plugins: [
    new HtmlWebpackPlugin({
      template: PUBLIC_PATH + '/index.html',
    }),
  ],
});
