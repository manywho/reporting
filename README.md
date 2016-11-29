ManyWho Reporting
======================

[![Build Status](https://travis-ci.org/manywho/reporting.svg)](https://travis-ci.org/manywho/reporting)

This application gives you the ability to process reporting data created by your Flows in ManyWho, and store it in your
internal systems. It currently supports storing Events, States and State Values.

## Usage

You will need to run your own instance of the application, but it's easy to spin up if you follow these instructions:

### Database

If you choose to store your reporting data in a database, you will find example schemas for the supported databases in
the [`src/main/sql`](src/main/sql) folder.

### Configuring

The available configuration settings for the application are:

* **database.type:** Currently supported values are `postgres` and `null` (defaults to `null`)
* **database.url:** A JDBC connection string, e.g. `jdbc:postgresql://localhost/reporting`
* **database.username**
* **database.password**

#### Environment Variables

If you choose to configure the application at runtime, by using environment variables, you will need to run the 
application like so:

```bash
$ DATABASE_TYPE=postgres DATABASE_URL=jdbc:postgresql://localhost/reporting DATABASE_USERNAME=postgres DATABASE_PASSWORD=password java -jar target/reporting-*.jar
```

#### Heroku

If you are running the application on Heroku along with one of their relational database addons, no further 
configuration is necessary as the provided `JDBC_DATABASE_URL` has all the needed information and is detected 
automatically.

#### Properties File

If you choose to configure the application using a properties file, you will need to have Apache Ant installed, then 
you can generate a configuration file by running the provided `build.xml` script:

```bash
$ ant -Ddatabase.type=postgres -Ddatabase.url=jdbc:postgresql://localhost/reporting -Ddatabase.username=postgres -Ddatabase.password=password
```

### Building

To build the service, you will need to have Maven 3 and a Java 8 implementation installed (OpenJDK and Oracle Java SE 
are both supported).

Now you can build the runnable shaded JAR:

```bash
$ mvn clean package
```

### Running

The application is a Jersey JAX-RS application, that by default is run under the Grizzly2 server on port 8080 (if you
use the packaged JAR).

#### Defaults

Running the following command will start the service listening on `0.0.0.0:8080/api/reporting/1`:

```bash
$ java -jar target/reporting-*.jar
```

#### Custom Port

You can specify a custom port to run the application on by passing the `server.port` property when running the JAR. The
following command will start the service listening on port 9090 (`0.0.0.0:9090/api/reporting/1`):

```bash
$ java -Dserver.port=9090 -jar target/reporting-*.jar
```

## Contributing

Contribution are welcome to the project - whether they are feature requests, improvements or bug fixes! Refer to 
[CONTRIBUTING.md](CONTRIBUTING.md) for our contribution requirements.

## License

This service is released under the [MIT License](http://opensource.org/licenses/mit-license.php).