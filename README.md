<p align="center">
 <img src="https://user-images.githubusercontent.com/45015114/155889609-9b2a0051-d86c-4c13-a549-e03836663ef0.png" align="center" alt="repo-reporter" />
 <h2 align="center">repo-reporter</h2>
 <p align="center">Is an easy to use api for generating online custom badges and github profiles summery and repository reports as SVG.</p>
</p>
<p align="center">
    	<a href="https://github.com/TheXSolutions/repo-reporter/releases/tag/v1.0.0">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=repo-reporter%20v1.1.0&logo=github&size=m&bg=random" />
    	</a>
    	<a href="https://github.com/TheXSolutions/repo-reporter/search?l=java">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=17&logo=java&size=m&bg=random" />
    	</a>
	<a href="https://github.com/TheXSolutions/repo-reporter/blob/main/LICENSE">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=MIT&logo=scale-balanced&size=m&bg=random" />
    </a>
    <a href="https://github.com/TheXSolutions/repo-reporter/releases/tag/v1.1.0">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=%20%DA%AF%D8%B2%D8%A7%D8%B1%D8%B4%DA%AF%D8%B1-%D9%85%D8%AE%D8%B2%D9%86%20%D9%86%D8%B3%D8%AE%D9%87%201.1.0&logo=github&size=m&dir=rtl&bg=random" />
    </a>
</p>
<p align="center">
	Let's discuss about new ideas:
</p>
<p align="center">
    <a href="https://discord.gg/u3SsX89J">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=TheX's%20server&logo=discord&bg=5858be&size=m" />
    </a>
</p>
<p align="center">
	If you like this project, please buy us a coffee!
</p>
<p align="center">
	<a href="https://thex.solutions/donate">
      		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=bc1qr3k6c9gh5ef6wk3ynmjpjkr2kjj0tckdcn8aa7&logo=bitcoin-sign&bg=fff&color=ef730f&size=m" />
	</a>
</p>
<p align="center">
	<a href="https://thex.solutions/donate">
		<img src="https://repo-reporter.thex.solutions/api/badge/link?title=0x130a1a681fd6ec43fd23a6a46bcaea7f311595fe&logo=ethereum&bg=fff&color=413946&size=m" />
	</a>
</p>
<p align="center">
	<img src="https://repo-reporter.thex.solutions/api/badge/logo?logo=heart&bg=fff&color=f23d96&size=s" />
</p>

## What Is In V1.1.0
- Support for inline query params.
- Support for short inline query params(only required).
- Support for 3 different param splitter(underscore, hyphen, space).
- Add default colors. you can now pass name of color beside hex.
- Add random color generator for badges backgrounds or text colors.

## How To Use
Here is a quick example of how to use the api. For more information, please visit the [repo-reporter website](https://repo-reporter.thex.solutions/) or read the [docs](https://github.com/TheXSolutions/repo-reporter/tree/main/docs).

### Default Colors
Instead of passing colors as hex you can use our pre-defined default colors names:

`repo-reporter.thex.solutions/api/badge/title?title=color&bg=<COLOR_NAME>`

![](https://repo-reporter.thex.solutions/api/badge/title?title=red&bg=red&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=blue&bg=blue&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=cyan&bg=cyan&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=green&bg=green&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=yellow&bg=yellow&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=orange&bg=orange&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=purple&bg=purple&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=pink&bg=pink&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=lavender&bg=lavender&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=brown&bg=brown&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=gray&bg=gray&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=black&bg=black&size=m)
![](https://repo-reporter.thex.solutions/api/badge/title?title=white&bg=white&size=m)

**names aren't case-sensitive.**

Think of a new cool color? Please let us know<3.

### Random Colors
For generating random colors you can use the following api with a random param as `bg` or `color` :

`repo-reporter.thex.solutions/api/badge/title?title=random&bg=random`

![](https://repo-reporter.thex.solutions/api/badge/title?title=random&bg=random&size=m)

**We strongly recommend you to do not use random colors for badge's text color! Because the random color produced can not match the background color in contrast and make it difficult to see your text in the badge.**

### Inline Query Params
Instead of passing the params as query params you can use inline params to just pass a string as design:

`repo-reporter.thex.solutions/api/badge/inline/<BADGE>/<SOME_DESIGN>`

Or want to pass less params? You can use short inline:

`repo-reporter.thex.solutions/api/badge/inline/<BADGE>/<SOME_SHORT_DESIGN>`

#### Params Splitters
You can use underscore, hyphen or space as a param splitter.

`param1 param2 param3...`

`param1_param2_param3...`

`param1-param2-param3...`

**Please take a look at each badge's examples to see how to inline params.**

### Profile Badge
For generating profile badges you can use the following api with your desired GitHub account id param :

`repo-reporter.thex.solutions/api/badge/profile?id=<YOUR-GITHUB-ACCOUNT-ID>`

Inline example:

`repo-reporter.thex.solutions/api/badge/inline/profile/<THEME>-<YOUR-GITHUB-ACCOUNT-ID>-<BG>-<COLOR>`

Short inline example:

`repo-reporter.thex.solutions/api/badge/inline/short/profile/<YOUR-GITHUB-ACCOUNT-ID>-<BG>-<COLOR>`

[![](https://repo-reporter.thex.solutions/api/badge/profile?id=TheXSolutions&color=787878)](https://github.com/TheXSolutions) [![](https://repo-reporter.thex.solutions/api/badge/profile?id=shuoros&color=787878)](https://github.com/shuoros)

### Link Badge
For generating link badges you can use the following api with two title and logo params :

`repo-reporter.thex.solutions/api/badge/link?title=Hello%20World&logo=globe`

Inline example:

`repo-reporter.thex.solutions/api/badge/inline/link/<DIRCTION>-<SIZE>-<THEME>-<TITLE>-<LOGO>-<BG>-<COLOR>-<LINK>`

Short inline example:

`repo-reporter.thex.solutions/api/badge/inline/short/link/<TITLE>-<LOGO>-<BG>-<SIZE>`

![](https://repo-reporter.thex.solutions/api/badge/link?title=Hello%20World&logo=globe)

To make an RTL link badge you must pass a dir parameter:

`repo-reporter.thex.solutions/api/badge/link?title=Hello%20World&logo=globe&dir=rtl`

![](https://repo-reporter.thex.solutions/api/badge/link?title=سلام%20دنیا&logo=globe&dir=rtl)

**! Learn about other params in [/docs](https://github.com/TheXSolutions/repo-reporter/tree/main/docs).**

### Logo Badge
For generating logo badges you can use the following api with a logo param :

`repo-reporter.thex.solutions/api/badge/logo?logo=peace`

Inline example:

`repo-reporter.thex.solutions/api/badge/inline/logo/<SIZE>-<THEME>-<LOGO>-<BG>-<COLOR>-<LINK>`

Short inline example:

`repo-reporter.thex.solutions/api/badge/inline/short/logo/<LOGO>-<BG>-<SIZE>`

![](https://repo-reporter.thex.solutions/api/badge/logo?logo=peace)

**! See list of supported logos and icons and learn about other params in [/docs](https://github.com/TheXSolutions/repo-reporter/tree/main/docs).**

### Title Badge
for generating title badges you can use the following api with a title param :

`repo-reporter.thex.solutions/api/badge/title?title=peace`

Inline example:

`repo-reporter.thex.solutions/api/badge/inline/title/<SIZE>-<THEME>-<TITLE>-<BG>-<COLOR>-<LINK>`

Short inline example:

`repo-reporter.thex.solutions/api/badge/inline/short/title/<TITLE>-<BG>-<SIZE>`

![](https://repo-reporter.thex.solutions/api/badge/title?title=peace)

**! Learn about other params in [/docs](https://github.com/TheXSolutions/repo-reporter/tree/main/docs).**

## Authors
repo-reporter is developed by [Soroush Shemshadi](https://github.com/shuoros) and [contributors](https://github.com/TheXSolutions/repo-reporter/blob/main/CONTRIBUTORS.md).

## Contribution
If you want to contribute on this project, Please read the [contribution guide](https://github.com/TheXSolutions/repo-reporter/blob/main/CONTRIBUTE.md).

## Releases
To see the changes in different versions of repo-reporter, you can read the [release notes](https://github.com/TheXSolutions/repo-reporter/blob/main/RELEASENOTES.md).

## Issues
If you encounter a bug or vulnerability, please read the [issue policy](https://github.com/TheXSolutions/repo-reporter/blob/main/ISSUES.md).

## Documentation
To learn how to work with repo-reporter, please take a look at the [/docs](https://github.com/TheXSolutions/repo-reporter/tree/main/docs) folder.

## Acknowledgement
A great thanks to [@sarahrajabi](https://github.com/sarahrajabi) for designing the logo.


Made with ![](https://repo-reporter.thex.solutions/api/badge/logo?logo=heart&bg=fff&color=f23d96&size=s)  and ![](https://repo-reporter.thex.solutions/api/badge/logo?logo=java&bg=black&color=orange&size=s).