const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const SRC_PATH = path.resolve(__dirname, './src');
const BUILD_PATH = path.resolve(__dirname, './build');
const PUBLIC_PATH = path.resolve(__dirname, './public')

module.exports = {
  entry: SRC_PATH + '/index.tsx',

  output: {
    path: BUILD_PATH,
    filename: 'bundle.js',
  },

  mode: process.env.NODE_ENV || 'development',

  resolve: {
    modules: [SRC_PATH, 'node_modules'],
    extensions: [ '.tsx', '.ts', '.js'],
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
        test: /\.(css|scss)$/,
        use: ['style-loader', 'css-loader', 'sass-loader'],
      },
      {
        test: /\.module.css$/,
        use: [
          {
            loader: "css-loader",
            options: {
              modules: true,
            },
          },
        ],
      },
      {
        test: /\.(jpg|jpeg|png|gif|mp3|svg)$/,
        use: ['file-loader']
      },
    ],
  },

  plugins: [
    new HtmlWebpackPlugin({
      template: PUBLIC_PATH + '/index.html',
    }),
  ],
};
