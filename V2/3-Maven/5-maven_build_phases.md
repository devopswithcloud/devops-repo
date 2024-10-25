
# Maven Build Phases and Unit Testing

Maven operates on a series of **build phases** that make up the project lifecycle. Each phase represents a specific stage in the process of building a project. 

## 1. Build Phases/Goals in Maven

### `validate`
- This phase validates the project structure and ensures all necessary information is available.

### `compile`
- Compiles the source code and generates `.class` files in the `target/` folder.
    ```bash
    mvn compile
    ```

### `test`
- Runs the unit tests that are located in the `src/test` directory.
- If any test fails, Maven stops the build process, and a package will not be created.

    **Unit Testing Details:**
    - **JUnit Framework**: For Java-based projects, the JUnit framework is commonly used for unit tests. These tests validate the smallest parts of the code.
    - **Skipping Tests**: Maven allows you to skip tests with the following options:
        - Skip running tests but still compile them:
          ```bash
          mvn clean package -DskipTests
          ```
        - Skip both compiling and running the tests:
          ```bash
          mvn clean package -Dmaven.test.skip=true
          ```

    **JUnit Example Dependency in `pom.xml`:**
    ```xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    ```

    **Important Note**: If any unit test fails, Maven will not proceed to the `package` phase. To skip both compiling and running the tests, use the `-Dmaven.test.skip=true` option.

### `package`
- Packages the compiled `.class` files into a deliverable (e.g., `.jar` or `.war`) as defined in the `pom.xml`.
    ```bash
    mvn package
    ```

### `install`
- Copies the generated `.jar` or `.war` file into the local Maven repository (`~/.m2`), making it available for use in other projects.
    ```bash
    mvn install
    ```

### `deploy`
- Copies the packaged file to a remote repository (e.g., Maven Central or a private repository), making it accessible for other developers or applications.
    ```bash
    mvn deploy
    ```

### `clean`
- Removes the `target/` directory and any files generated during previous builds. This is typically run before starting a new build to ensure a clean workspace.
    ```bash
    mvn clean
    ```


---

## 2. Summary of Build Phases

- **Validate**: Ensures that the project structure is correct.
- **Compile**: Compiles the source code into `.class` files.
- **Test**: Runs unit tests to verify the functionality of the code.
- **Package**: Packages the compiled code into a `.jar` or `.war` file.
- **Install**: Places the package into the local Maven repository.
- **Deploy**: Deploys the package to a remote repository for others to use.
- **Clean**: Cleans up the `target/` directory to prepare for a fresh build.

---

