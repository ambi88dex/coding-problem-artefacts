We execute NodeJS, Standalone JavasScript under the Node/NPM execution environment.

In both cases your main file should be named as `geektrust.js`.

# Solution without Build files

This main file, `geektrust.js` should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.js` file will look like this

```javascript
const filename = process.argv[2];
// parse the file and process the command
// print the output
```

We will execute the program using the command 

```
node geektrust.js
```


# Solution with Build files

For Node JS we support the following dependency/build system as of now

* [NPM](https://www.geeksforgeeks.org/node-js-npm-node-package-manager/)
* [Yarn](https://yarnpkg.com/lang/en/)

## NPM

NPM is the default package manager for NodeJS. NPM can install all the dependencies of a project through the package.json file. It can also update and uninstall packages. In the package.json file, each dependency can specify a range of valid versions using the semantic versioning scheme, allowing developers to auto-update their packages while at the same time avoiding unwanted breaking changes.

A sample `package.json` file can be downloaded from [here](https://raw.githubusercontent.com/geektrust/coding-problem-artefacts/master/NodeJS/package.json)

In your `package.json` file make sure you have an entry for the start script which points to the execution of `geektrust.js`

```javascript
"scripts": {
    "start": "node geektrust.js"
}
```

### Building and running the solution

This main file, `geektrust.js` should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.js` file will look like this

```javascript
const filename = process.argv[2];
// parse the file and process the command
// print the output
```

We build and run the solution by using the following commands

```
npm install --silent
npm start --silent <absolute_path_to_input_file>
```


## Yarn

We also support yarn as a build tool if you want to use it. 

Your project should have the `package.json` file which handles all the dependencies. In that file make sure you have an entry for the start script which points to the execution of `geektrust.js`

```javascript
"scripts": {
    "start": "node geektrust.js"
}
```


### Building and running the solution

This main file, `geektrust.js` should receive in the command line argument and parse the file passed in. Once the file is parsed and the application processes the commands, it should only print the output.

For e.g your `geektrust.js` file will look like this

```javascript
const filename = process.argv[2];
// parse the file and process the command
// print the output
```

We build and run the solution by using the following commands

```javascript
yarn install --silent
yarn run --silent start <absolute_path_to_input_file>
```