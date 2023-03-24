const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const SRC_PATH = path.resolve(__dirname, './src');

module.exports = {
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

  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      },
      {
        test: /\.tsx?$/,
        exclude: /node_modules/,
        loader: 'ts-loader',
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
    new CleanWebpackPlugin(),
  ],
};
