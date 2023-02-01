const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const autoprefixer = require('autoprefixer');

const SRC_PATH = path.resolve(__dirname, './src');
const BUILD_PATH = path.resolve(__dirname, './build');
const PUBLIC_PATH = path.resolve(__dirname, './public');

const devMode = process.env.NODE_ENV !== 'production';

module.exports = {
  entry: SRC_PATH + '/index.tsx',

  output: {
    path: BUILD_PATH,
    filename: 'bundle.js',
  },

  mode: process.env.NODE_ENV || 'development',

  resolve: {
    modules: [SRC_PATH, 'node_modules'],
    extensions: ['.tsx', '.ts', '.js'],
    alias: {
      'assets': SRC_PATH + '/assets',
      'components': SRC_PATH + '/components',
      'pages': SRC_PATH + '/pages',
      'utils': SRC_PATH + '/utils',
      'types': SRC_PATH + '/types',
    }
  },

  devServer: {
    static: PUBLIC_PATH,
    compress: true,
    port: 8080,
    open: true,
  },

  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: ['babel-loader']
      },
      {
        test: /\.tsx?$/,
        exclude: /node_modules/,
        loader: 'ts-loader'
      },
      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          devMode ? 'style-loader' : MiniCssExtractPlugin.loader,
          {
            loader: 'css-loader',
            options: {
              importLoaders: 1,
              modules: {
                localIdentName: devMode ? '[name]__[local]___[hash:base64:5]' : '[hash:base64]',
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
      {
        test: /\.(png|svg|jpg|jpeg|gif)$/,
        type: 'asset/resource',
        generator: {
          filename: 'images/[name].[hash][ext]',
        }
      },
      {
        test: /\.(woff|woff2|eot|ttf|otf)$/i,
        type: 'asset/resource',
        generator: {
          filename: 'fonts/[name].[hash][ext]',
        }
      }
    ],
  },

  plugins: [
    new HtmlWebpackPlugin({
      template: PUBLIC_PATH + '/index.html',
    }),
    new MiniCssExtractPlugin(),
    new CleanWebpackPlugin(),
  ],
};
