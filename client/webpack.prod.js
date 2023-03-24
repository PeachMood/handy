const path = require('path');
const merger = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const autoprefixer = require('autoprefixer');

const common = require('./webpack.common.js');

// Source directory with React code
const SRC_PATH = path.resolve(__dirname, './src');
// Directory for webpack static files output (images, javascript, styles)
const STATIC_PATH = path.resolve(__dirname, './../server/src/main/resources/static');
// Directory for webpack html file output
const HTML_PATH = path.resolve(__dirname, './../server/src/main/resources/templates');
// Directory with html template for webpack
const TEMPLATE_PATH = path.resolve(__dirname, './public');

module.exports = merger.merge(common, {
  mode: 'production',

  entry: SRC_PATH + '/index.prod.tsx',

  output: {
    publicPath: '',
    path: STATIC_PATH,
    filename: 'bundle.js',
  },

  module: {
    rules: [
      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          MiniCssExtractPlugin.loader,
          {
            loader: 'css-loader',
            options: {
              importLoaders: 1,
              modules: {
                localIdentName: '[hash:base64]',
              },
            },
          },
          {
            loader: 'postcss-loader',
            options: {
              postcssOptions: {
                plugins: [
                  autoprefixer
                ],
              }
            }
          },
          "sass-loader",
        ],
      },
    ],
  },

  plugins: [
    new HtmlWebpackPlugin({
      template: TEMPLATE_PATH + '/index.html',
      filename: HTML_PATH + '/index.html',
    }),
    new MiniCssExtractPlugin()
  ],
});
