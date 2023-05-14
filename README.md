<p align="center">
 <img src="https://badgify.thex.solutions/api/counter/github/repo/shuoros/badgify?title=Badgify Visits" align="center" alt="badgify" />
 </br>
 </br>
 <img src="https://user-images.githubusercontent.com/45015114/157028899-efb256dd-efe6-47a8-895d-86a61f4f31c6.png" align="center" alt="badgify" />
 <h2 align="center">Badgify</h2>
 <p align="center">Is an easy-to-use API for generating online custom badges and GitHub profiles' summaries and repositories' reports as SVG.</p>
</p>
<p align="center">
    	<a href="https://github.com/shuoros/badgify/releases/tag/v1.2.0">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=badgify%20v1.3.0&icon=github&size=m&bg=random" />
    	</a>
    	<a href="https://github.com/shuoros/badgify/search?l=java">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=18&icon=java&size=m&bg=random" />
    	</a>
	<a href="https://github.com/shuoros/badgify/blob/main/LICENSE">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=MIT&icon=scale-balanced&size=m&bg=random" />
    </a>
    <a href="https://github.com/shuoros/badgify/releases/tag/v1.2.0">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=%D8%A8%D8%AF%D8%AC%DB%8C%D9%81%D8%A7%DB%8C%20%D9%86%D8%B3%D8%AE%D9%87%20%DB%B1.%DB%B3.%DB%B0&icon=github&size=m&dir=rtl&bg=random" />
    </a>
<p align="center">
    <a href="https://github.com/shuoros/badgify/issues/new/choose">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Reoprt%20Bug&bg=gray&size=m&theme=edge" />
    </a>
    <a href="https://github.com/shuoros/badgify/issues/new/choose">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Request%20Feature&bg=gray&size=m&theme=edge" />
    </a>
    <a href="#contribution">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Contribute&bg=gray&size=m&theme=edge" />
    </a>
    <a href="#contents">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=How%20To%20Use&bg=gray&size=m&theme=edge" />
    </a>
</p>
<p align="center">
	If you like this project, please buy a cup of coffee for me=))☕
</p>
<p align="center">
	<a href="https://commerce.coinbase.com/checkout/6e1472f5-3481-4949-84cf-a915e0cb8d0c">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=Donate%20With%20Crypto&icon=hand-holding-dollar&bg=ef730f&size=m&theme=edge" />
	</a>
</p>
<p align="center">
	<img src="https://badgify.thex.solutions/api/badge/icon?icon=heart&bg=fff&color=f23d96&size=s" /> & <img src="https://badgify.thex.solutions/api/badge/icon?icon=peace&bg=fff&color=0286a9&size=s" /> 
</p>
<p align="center">
	<a href="#">
		<img src="https://badgify.thex.solutions/api/badge/link?title=ENGLISH&icon=flag.us&bg=254a79&size=m" />
	</a>
    <a href="https://github.com/shuoros/badgify/tree/main/docs/READMES/FA.md">
		<img src="https://badgify.thex.solutions/api/badge/link?title=%D9%81%D8%A7%D8%B1%D8%B3%DB%8C&icon=flag.ir&bg=fff&size=m" />
	</a>
</p>

## What Is In V1.4.0

- JHipsetrize it! =))

## Contents
- [Install and Run](#install-and-run)
- [APIs](#apis)
    - [Counter Badge](#counter-badge)
    - [Social Badges](#social-badges)
        - [Supported Socials](#supported-socials)
    - [Profile Badge](#profile-badge)
    - [Link Badge](#link-badge)
    - [Icon Badge](#icon-badge)
    - [Title Badge](#title-badge)
- [Options](#options)
    - [Default Colors](#default-colors)
    - [Random Colors](#random-colors)
    - [Themes](#themes)
        - [Simple](#simple)
        - [Sharp](#sharp)
        - [Edge](#edge)
    - [Sizes](#sizes)
        - [Small](#small)
        - [Medium](#medium)
        - [Large](#large)
    - [Inline Query Params](#inline-query-params)
        - [Params Splitters](#params-splitters)
- [Authors](#authors)
- [Contribution](#contribution)
- [Releases](#releases)
- [Issues](#issues)
- [Documentation](#documentation)
- [Acknowledgement](#acknowledgement)

[//]: # (## Hosts)

[//]: # (You can use any of the following hosts to use badgify APIs:)

[//]: # ()
[//]: # (```md)

[//]: # (https://badgify.thex.solutions)

[//]: # (```)

## Install and Run

### Requirements
Having at least `java-11` on your machine installed would be best.

### Build

#### Packaging as jar
To build the final jar and optimize the Badgify for production, run:
```bash
./mvnw -Pprod clean verify
```

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files. To ensure everything worked, run:
```bash
java -jar target/*.jar
```

#### Packaging as war

To package Badgify as a war in order to deploy it to an application server, run:

```bash
./mvnw -Pprod,war clean verify
```

### Test

To launch Badgify's tests, run:

```
./mvnw verify
```

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

### Code quality

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker-compose -f src/main/docker/sonar.yml up -d
```

Note: I have turned off authentication in [src/main/docker/sonar.yml](src/main/docker/sonar.yml) for out of the box experience while trying out SonarQube, for real use cases turn it back on.

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the maven plugin.

Then, run a Sonar analysis:

```
./mvnw -Pprod clean verify sonar:sonar
```

If you need to re-run the Sonar phase, please be sure to specify at least the `initialize` phase since Sonar properties are loaded from the sonar-project.properties file.

```
./mvnw initialize sonar:sonar
```

### Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

```
docker-compose -f src/main/docker/mysql.yml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/mysql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
npm run java:docker
```

Or build a arm64 docker image when using an arm64 processor os like MacOS with M1 processor family running:

```
npm run java:docker:arm64
```

Then run:

```
docker-compose -f src/main/docker/app.yml up -d
```

When running Docker Desktop on MacOS Big Sur or later, consider enabling experimental `Use the new Virtualization framework` for better processing performance ([disk access performance is worse](https://github.com/docker/roadmap/issues/7)).

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## APIs

### Label Badge

**GET** `http://localhost:8080/api/badge/lable`

 *OPTIONS*
- `text`: String
- `icon`: [Icon](#icons)
- `fontColor`: [Color](#colors)
- `backgroundColor`: [Color](#colors)
- `size`: [Size](#sizes)
- `theme`: [Theme](#themes)

<details>
<summary>👀 Example</summary>
   
    http://localhost:8080/api/badge/label?text=Badgify&fontColor=lavender&size=l&theme=simple&backgroundColor=indigo&icon=github

![image](https://github.com/shuoros/badgify/assets/45015114/81eb4fdd-080e-48af-8e78-a3f6c31b7355)
</details>

### Icon Badge

**GET** `http://localhost:8080/api/badge/icon`

*OPTIONS*
- `icon`: [Icon](#icons)
- `fontColor`: [Color](#colors)
- `backgroundColor`: [Color](#colors)
- `size`: [Size](#sizes)
- `theme`: [Theme](#themes)

<details>
<summary>👀 Example</summary>

    http://localhost:8080/api/badge/icon?fontColor=lavender&size=l&theme=simple&backgroundColor=indigo&icon=github

![image](https://github.com/shuoros/badgify/assets/45015114/c907de5c-57b3-43a7-842e-3999d07bbd98)
</details>

### Text Badge

**GET** `http://localhost:8080/api/badge/text`

*OPTIONS*
- `text`: String
- `fontColor`: [Color](#colors)
- `backgroundColor`: [Color](#colors)
- `size`: [Size](#sizes)
- `theme`: [Theme](#themes)

<details>
<summary>👀 Example</summary>

    http://localhost:8080/api/badge/text?fontColor=lavender&size=l&theme=simple&backgroundColor=indigo&text=Badgify

![image](https://github.com/shuoros/badgify/assets/45015114/817921db-d902-4fa9-b510-d9d322ad2379)
</details>

### Counter Badge

#### for repository

**GET** `http://localhost:8080/api/badge/counter`

*OPTIONS*
- `id`: String (required)
- `type`: `repository` (required)
- `text`: String
- `fontColor`: [Color](#colors)
- `backgroundColor`: [Color](#colors)
- `size`: [Size](#sizes)
- `theme`: [Theme](#themes)

<details>
<summary>👀 Example</summary>

    http://localhost:8080/api/badge/counter?fontColor=lavender&size=l&theme=simple&backgroundColor=indigo&type=repository&icon=github&id=Badgify

![image](https://github.com/shuoros/badgify/assets/45015114/18fd31fc-30c3-4d86-a17e-c88c204a0328)
</details>

### Social Badge

**GET** `http://localhost:8080/api/badge/{social}/{id}`

*OPTIONS*
- `text`: String
- `icon`: [Icon](#icons)
- `fontColor`: [Color](#colors)
- `backgroundColor`: [Color](#colors)
- `size`: [Size](#sizes)
- `theme`: [Theme](#themes)

<details>
<summary>👀 Example</summary>

    http://localhost:8080/api/badge/twitter/shuoros

![image](https://github.com/shuoros/badgify/assets/45015114/355f135c-01c3-42ec-9fce-50bdaf4b373e)</details>

#### Supported Socials
`app-store`
```url
http://localhost:8080/api/badge/app_store/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/be1e4382-3490-4c2d-a301-ab569e7e7f2a)

`behance`
```url
http://localhost:8080/api/badge/behance/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/d3317cf5-13a2-4dd2-830e-9a68119108fd)

`discord`
```url
http://localhost:8080/api/badge/discord/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/f5373a25-02cd-435e-9826-7a2c76821566)

`dockerhub`
```url
http://localhost:8080/api/badge/dockerhub/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/85e3f5e2-3f52-405b-870d-040310bdcca0)

`dribbble`
```url
http://localhost:8080/api/badge/dribbble/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/62826eeb-3700-41d8-ba45-941ab829bd1f)

`dropbox`
```url
http://localhost:8080/api/badge/dropbox/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/1f44d7eb-4d70-4a91-bb1a-c3651932d740)

`facebook`
```url
http://localhost:8080/api/badge/facebook/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/e6afc0dd-e9a1-42bf-bd10-4a65d20f0084)

`github`
```url
http://localhost:8080/api/badge/github/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/9534111e-65e5-49a6-b0f5-404a51891616)

`gitlab`
```url
http://localhost:8080/api/badge/gitlab/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/9cf190ab-1751-4c7f-854b-bfaf8d56d711)

`goodreads`
```url
http://localhost:8080/api/badge/goodreads/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/898f8f81-9f29-4aed-b5f0-e60e3f770ba5)

`google-drive`
```url
http://localhost:8080/api/badge/google_drive/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/56a2eddc-3c5e-4d90-806d-2d59d6891805)

`google-play`
```url
http://localhost:8080/api/badge/google_play/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/75147911-84a6-496d-bc9b-2c0638edb46e)

`instagram`
```url
http://localhost:8080/api/badge/instagram/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/53afb52c-6b92-4062-a740-8aa2ce50ea04)

`kaggle`
```url
http://localhost:8080/api/badge/kaggle/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/143e3006-ab1f-4153-b65e-37db47336695)

`kickstarter`
```url
http://localhost:8080/api/badge/kickstarter/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/1357d487-5a4f-4ac6-a629-818ddf3fd89e)

`linkedin`
```url
http://localhost:8080/api/badge/linkedin/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/ab22956c-ce78-49b1-a4e0-ec54a8c05b57)

`medium`
```url
http://localhost:8080/api/badge/medium/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/43237297-2339-47b6-8095-44d156eade39)

`paypal`
```url
http://localhost:8080/api/badge/paypal/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/f037c10a-6c40-46ed-97bd-7bbfb30ca199)

`pinterest`
```url
http://localhost:8080/api/badge/pinterest/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/46ca673b-af7f-4d56-9fbc-ee022aab0bd8)

`quora`
```url
http://localhost:8080/api/badge/quora/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/8850294c-7f56-496e-8eed-bef801bbf655)

`reddit`
```url
http://localhost:8080/api/badge/reddit/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/fc105208-3571-427e-9171-43df9bf6b4d2)

`skype`
```url
http://localhost:8080/api/badge/skype/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/90ea7968-5e57-4536-8449-70e8996d75e3)

`slack`
```url
http://localhost:8080/api/badge/slack/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/02588917-63b1-47c4-b2fc-eaeed013dd8f)

`snapchat`
```url
http://localhost:8080/api/badge/snapchat/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/877fa93c-985a-48cf-b69a-a1ca9e67bb44)

`spotify`
```url
http://localhost:8080/api/badge/spotify/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/22a98165-eddf-4789-b851-cd65e36224fa)

`stack-exchange`
```url
http://localhost:8080/api/badge/stackexchange/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/ce668ed5-3234-4575-89dc-3ca3867a10b9)

`stackoverflow`
```url
http://localhost:8080/api/badge/stackoverflow/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/476a14fc-1bc9-4bba-8959-5cb21f83290e)

`steam`
```url
http://localhost:8080/api/badge/app_store/{id}
```

![](https://badgify.thex.solutions/api/social/steam/badgify)

`telegram`
```url
http://localhost:8080/api/badge/telegram/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/2be06971-8339-4d0c-a70b-050f0ae0a948)

`tiktok`
```url
http://localhost:8080/api/badge/tiktok/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/d61c6b27-24e8-4827-a4f5-d2b96e55e45c)

`twitch`
```url
http://localhost:8080/api/badge/twitch/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/7fee76db-d999-437b-ae74-6dfccbae45ca)

`twitter`
```url
http://localhost:8080/api/badge/app_store/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/037abb2d-cc31-4986-9451-ec2c9042f48b)

`yahoo-mail`
```url
http://localhost:8080/api/badge/yahoo_mail/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/7741f4d3-7246-4607-96f1-3594fff4732a)

`youtube`
```url
http://localhost:8080/api/badge/youtube/{id}
```

![image](https://github.com/shuoros/badgify/assets/45015114/8e03cee8-8580-4605-b4c2-e9cd1df7acd6)

**If there is a missed social media please let me now by creating a new Issue**

## Options
Here are quick examples of how to use APIs. For more information, please visit the [badgify website](https://badgify.thex.solutions/) or read the [/docs](https://github.com/shuoros/badgify/tree/main/docs).

### Default Colors
Instead of passing colors as hex you can use our pre-defined default colors names:

```md
badgify.thex.solutions/api/badge/title?title=color&bg=<COLOR_NAME>
```

![](https://badgify.thex.solutions/api/badge/title?title=red&bg=red&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=blue&bg=blue&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=cyan&bg=cyan&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=green&bg=green&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=yellow&bg=yellow&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=orange&bg=orange&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=purple&bg=purple&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=pink&bg=pink&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=lavender&bg=lavender&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=brown&bg=brown&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=gray&bg=gray&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=black&bg=black&size=m)
![](https://badgify.thex.solutions/api/badge/title?title=white&bg=white&size=m)

**Colors names aren't case-sensitive!**

Thinking of a new cool color? Please let us know<3.

### Random Colors
For generating random colors you can use the following api with a random param as `bg` or `color` :

```md
badgify.thex.solutions/api/badge/title?title=random&bg=random
```

![](https://badgify.thex.solutions/api/badge/title?title=random&bg=random&size=m)

**We strongly recommend you to do not use random colors for badge's text color! Because the produced random color may not match the background color in contrast and make it difficult to see your text in the badge.**

### Themes
You can choose one of the available themes for your badge.

#### Simple
Simple is default theme of badges. If you want to use this theme, you do not need to pass it in parameters.

```md
badgify.thex.solutions/api/badge/link?title=Simple&icon=github
```

![](https://badgify.thex.solutions/api/badge/link?title=Simple&icon=github&bg=gray)

```md
badgify.thex.solutions/api/badge/title?title=Simple
```

![](https://badgify.thex.solutions/api/badge/title?title=Simple&bg=gray)

```md
badgify.thex.solutions/api/badge/icon?icon=github
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&bg=gray)

#### Sharp
To use this theme in your badges, you must pass `theme=sharp` parameter in your request.

```md
badgify.thex.solutions/api/badge/link?title=Sharp&icon=github&theme=sharp
```

![](https://badgify.thex.solutions/api/badge/link?title=Sharp&icon=github&theme=sharp&bg=gray)

```md
badgify.thex.solutions/api/badge/title?title=Sharp&theme=sharp
```

![](https://badgify.thex.solutions/api/badge/title?title=Sharp&theme=sharp&bg=gray)

```md
badgify.thex.solutions/api/badge/icon?icon=github&theme=sharp
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&theme=sharp&bg=gray)

#### Edge
To use this theme in your badges, you must pass theme=edge parameter in your request.

```md
badgify.thex.solutions/api/badge/link?title=Edge&icon=github&theme=edge
```

![](https://badgify.thex.solutions/api/badge/link?title=Edge&icon=github&theme=edge&bg=gray)

```md
badgify.thex.solutions/api/badge/title?title=Edge&theme=edge
```

![](https://badgify.thex.solutions/api/badge/title?title=Edge&theme=edge&bg=gray)

```md
badgify.thex.solutions/api/badge/icon?icon=github&theme=edge
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&theme=edge&bg=gray)

Any idea about new themes? Feel free to tell us<3

### Sizes
There are three renderable sizes for badges. Small, medium and large that you can choose any of these sizes for your badge.

#### Small
Small is default size of badges. If you want to use this size, you do not need to pass it in parameters.

```md
badgify.thex.solutions/api/badge/link?title=Small&icon=github
```

![](https://badgify.thex.solutions/api/badge/link?title=Small&icon=github&bg=gray)

```md
badgify.thex.solutions/api/badge/title?title=Small
```

![](https://badgify.thex.solutions/api/badge/title?title=Small&bg=gray)


```md
badgify.thex.solutions/api/badge/icon?icon=github
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&bg=gray)

#### Medium
To use medium size for your badges, you must pass `size=m` parameter in your request.

```md
badgify.thex.solutions/api/badge/link?title=Medium&icon=github&size=m
```

![](https://badgify.thex.solutions/api/badge/link?title=Medium&icon=github&bg=gray&size=m)

```md
badgify.thex.solutions/api/badge/title?title=Medium&size=m
```

![](https://badgify.thex.solutions/api/badge/title?title=Medium&bg=gray&size=m)


```md
badgify.thex.solutions/api/badge/icon?icon=github&size=m
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&bg=gray&size=m)

#### Large
To use large size for your badges, you must pass `size=l` parameter in your request.

```md
badgify.thex.solutions/api/badge/link?title=Large&icon=github&size=l
```

![](https://badgify.thex.solutions/api/badge/link?title=Large&icon=github&bg=gray&size=l)

```md
badgify.thex.solutions/api/badge/title?title=Large&size=l
```

![](https://badgify.thex.solutions/api/badge/title?title=Large&bg=gray&size=l)


```md
badgify.thex.solutions/api/badge/icon?icon=github&size=l
```

![](https://badgify.thex.solutions/api/badge/icon?icon=github&bg=gray&size=l)

### Inline Query Params
Instead of passing the params as query params you can use inline params to just pass a string as design:

```md
badgify.thex.solutions/api/badge/inline/<BADGE>/<SOME_DESIGN>
```

Or want to pass less params? You can use short inline:

```md
badgify.thex.solutions/api/badge/inline/<BADGE>/<SOME_SHORT_DESIGN>
```

#### Params Splitters
You can use underscore, hyphen or space as a param splitter.

`param1 param2 param3...`

`param1_param2_param3...`

`param1-param2-param3...`

**Please take a look at each badge's examples to see how to use inline params.**

## Authors
badgify is developed by [Soroush Shemshadi](https://github.com/shuoros) and [contributors](https://github.com/shuoros/badgify/blob/main/CONTRIBUTORS.md).

## Contribution
If you want to contribute on this project, Please read the [contribution guide](https://github.com/shuoros/badgify/blob/main/CONTRIBUTE.md).

## Releases
To see the changes in different versions of badgify, you can read the [release notes](https://github.com/shuoros/badgify/blob/main/RELEASENOTES.md).

## Issues
If you encounter a bug or vulnerability, please read the [issue policy](https://github.com/shuoros/badgify/blob/main/ISSUES.md).

## Documentation
To learn how to work with badgify, please take a look at the [/docs](https://github.com/shuoros/badgify/tree/main/docs) folder.

## Acknowledgement
A great thanks to [@sarahrajabi](https://github.com/sarahrajabi) for designing the icon.

And thanks to all the contributors, the people who reported the bugs and all those who made it possible for us to provide this great software.
\
\
\
\
\
![](https://badgify.thex.solutions/api/badge/title?title=Made%20with%20❤%20and%20Java%3D%29%29&bg=lavender&size=l)
