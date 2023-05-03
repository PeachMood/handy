const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const paths = {
  src: path.resolve(__dirname, './src'),
  build: path.resolve(__dirname, './build'),
  public: path.resolve(__dirname, './public'),
}

const webpackConfig = {
  entry: paths.src + '/index.tsx',

  output: {
    publicPath: '',
    path: paths.build,
    filename: 'bundle.js',
  },

  resolve: {
    modules: [paths.src, 'node_modules'],
    extensions: ['.tsx', '.ts', '.js'],
    alias: {
      'assets': paths.src + '/assets',
      'contexts': paths.src + '/contexts',
      'hooks': paths.src + '/hooks',
      'components': paths.src + '/components',
      'pages': paths.src + '/pages',
      'routes': paths.src + '/routes',
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
    new HtmlWebpackPlugin({
      template: paths.public + '/index.html',
    }),
    new CleanWebpackPlugin(),
  ],
};

module.exports = { paths, webpackConfig };
