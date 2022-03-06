<p align="center">
 <img src="https://user-images.githubusercontent.com/45015114/156922352-57d37457-1ac1-459f-b447-8734b9223bdc.png" align="center" alt="badgify" />
 <h2 align="center">Badgify</h2>
 <p align="center">Is an easy-to-use API for generating online custom badges and GitHub profiles' summaries and repositories' reports as SVG.</p>
</p>
<p align="center">
    	<a href="https://github.com/TheXSolutions/badgify/releases/tag/v1.2.0">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=badgify%20v1.2.0&icon=github&size=m&bg=random" />
    	</a>
    	<a href="https://github.com/TheXSolutions/badgify/search?l=java">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=17&icon=java&size=m&bg=random" />
    	</a>
	<a href="https://github.com/TheXSolutions/badgify/blob/main/LICENSE">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=MIT&icon=scale-balanced&size=m&bg=random" />
    </a>
    <a href="https://github.com/TheXSolutions/badgify/releases/tag/v1.2.0">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=%D8%A8%D8%AF%D8%AC%DB%8C%D9%81%D8%A7%DB%8C%20%D9%86%D8%B3%D8%AE%D9%87%20%DB%B1.%DB%B2.%DB%B0&icon=github&size=m&dir=rtl&bg=random" />
    </a>
<p align="center">
    <a href="https://github.com/TheXSolutions/badgify/issues/new/choose">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Reoprt%20Bug&bg=254a79&size=m&theme=edge" />
    </a>
    <a href="https://github.com/TheXSolutions/badgify/issues/new/choose">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Request%20Feature&bg=254a79&size=m&theme=edge" />
    </a>
    <a href="https://github.com/TheXSolutions/badgify#contribution">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=Contribute&bg=254a79&size=m&theme=edge" />
    </a>
    <a href="https://github.com/TheXSolutions/badgify#how-to-use">
      		<img src="https://badgify.thex.solutions/api/badge/title?title=How%20To%20Use&bg=254a79&size=m&theme=edge" />
    </a>
</p>
<p align="center">
	If you like this project, please buy us a coffee!
</p>
<p align="center">
	<a href="https://thex.solutions/donate">
      		<img src="https://badgify.thex.solutions/api/badge/link?title=bc1qr3k6c9gh5ef6wk3ynmjpjkr2kjj0tckdcn8aa7&icon=bitcoin-sign&bg=fff&color=ef730f&size=m" />
	</a>
</p>
<p align="center">
	<a href="https://thex.solutions/donate">
		<img src="https://badgify.thex.solutions/api/badge/link?title=0x130a1a681fd6ec43fd23a6a46bcaea7f311595fe&icon=ethereum&bg=fff&color=413946&size=m" />
	</a>
</p>
<p align="center">
	<img src="https://badgify.thex.solutions/api/badge/icon?icon=heart&bg=fff&color=f23d96&size=s" /> & <img src="https://badgify.thex.solutions/api/badge/icon?icon=peace&bg=fff&color=0286a9&size=s" /> 
</p>
<p align="center">
	<a href="https://github.com/TheXSolutions/badgify/blob/main/README.md">
		<img src="https://badgify.thex.solutions/api/badge/link?title=ENGLISH&icon=flag.us&bg=254a79&size=m" />
	</a>
    <a href="https://github.com/TheXSolutions/badgify/tree/main/docs/READMES/FA.md">
		<img src="https://badgify.thex.solutions/api/badge/link?title=فارسی&icon=flag.ir&bg=fff&size=m" />
	</a>
</p>

## What Is In V1.2.0
- Add flags icon support.
- Add iconscout colory brands icons.
- Add two new sharp and edge themes.

## Contents
- [Hosts](#hosts)
- [How To Use](#how-to-use)
  - [Default Colors](#default-colors)
  - [Random Colors](#random-colors)
  - [Inline Query Params](#inline-query-params)
    - [Params Splitters](#params-splitters)
- [APIs](#apis)
  - [Profile Badge](#profile-badge)
  - [Link Badge](#link-badge)
  - [Icon Badge](#icon-badge)
  - [Title Badge](#title-badge)
- [Authors](#authors)
- [Contribution](#contribution)
- [Releases](#releases)
- [Issues](#issues)
- [Documentation](#documentation)
- [Acknowledgement](#acknowledgement)

## Hosts
You can use any of the following hosts to badgify APIs:

```md
https://badgify.thex.solutions
```

## How To Use
Here is a quick example of how to use APIs. For more information, please visit the [badgify website](https://badgify.thex.solutions/) or read the [/docs](https://github.com/TheXSolutions/badgify/tree/main/docs).

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

**We strongly recommend you to do not use random colors for badge's text color! Because the random color produced can not match the background color in contrast and make it difficult to see your text in the badge.**

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

**Please take a look at each badge's examples to see how to inline params.**

## APIs

### Profile Badge
For generating profile badges you can use the following api with your desired GitHub account id param :

```md
badgify.thex.solutions/api/badge/profile?id=<YOUR-GITHUB-ACCOUNT-ID>
```

Inline example:

```md
badgify.thex.solutions/api/badge/inline/profile/<THEME>-<YOUR-GITHUB-ACCOUNT-ID>-<BG>-<COLOR>
```

Short inline example:

```md
badgify.thex.solutions/api/badge/inline/short/profile/<YOUR-GITHUB-ACCOUNT-ID>-<BG>-<COLOR>
```

[![](https://badgify.thex.solutions/api/badge/profile?id=TheXSolutions&color=787878)](https://github.com/TheXSolutions) [![](https://badgify.thex.solutions/api/badge/profile?id=shuoros&color=787878)](https://github.com/shuoros)

### Link Badge
For generating link badges you can use the following api with two title and icon params :

```md
badgify.thex.solutions/api/badge/link?title=Hello%20World&icon=globe
```

Inline example:

```md
badgify.thex.solutions/api/badge/inline/link/<DIRCTION>-<SIZE>-<THEME>-<TITLE>-<LOGO>-<BG>-<COLOR>-<LINK>
```

Short inline example:

```md
badgify.thex.solutions/api/badge/inline/short/link/<TITLE>-<LOGO>-<BG>-<SIZE>
```

![](https://badgify.thex.solutions/api/badge/link?title=Hello%20World&icon=globe)

To make an RTL link badge you must pass a dir parameter:

```md
badgify.thex.solutions/api/badge/link?title=Hello%20World&icon=globe&dir=rtl
```

![](https://badgify.thex.solutions/api/badge/link?title=سلام%20دنیا&icon=globe&dir=rtl)

**! Learn about other params in [/docs](https://github.com/TheXSolutions/badgify/tree/main/docs).**

### Icon Badge
For generating icon badges you can use the following api with a icon param :

```md
badgify.thex.solutions/api/badge/icon?icon=peace
```

Inline example:

```md
badgify.thex.solutions/api/badge/inline/icon/<SIZE>-<THEME>-<LOGO>-<BG>-<COLOR>-<LINK>
```

Short inline example:

```md
badgify.thex.solutions/api/badge/inline/short/icon/<LOGO>-<BG>-<SIZE>
```

![](https://badgify.thex.solutions/api/badge/icon?icon=peace)

**! See list of supported icons and icons and learn about other params in [/docs](https://github.com/TheXSolutions/badgify/tree/main/docs).**

### Title Badge
for generating title badges you can use the following api with a title param :

```md
badgify.thex.solutions/api/badge/title?title=peace
```

Inline example:

```md
badgify.thex.solutions/api/badge/inline/title/<SIZE>-<THEME>-<TITLE>-<BG>-<COLOR>-<LINK>
```

Short inline example:

```md
badgify.thex.solutions/api/badge/inline/short/title/<TITLE>-<BG>-<SIZE>
```

![](https://badgify.thex.solutions/api/badge/title?title=peace)

**! Learn about other params in [/docs](https://github.com/TheXSolutions/badgify/tree/main/docs).**

## Authors
badgify is developed by [Soroush Shemshadi](https://github.com/shuoros) and [contributors](https://github.com/TheXSolutions/badgify/blob/main/CONTRIBUTORS.md).

## Contribution
If you want to contribute on this project, Please read the [contribution guide](https://github.com/TheXSolutions/badgify/blob/main/CONTRIBUTE.md).

## Releases
To see the changes in different versions of badgify, you can read the [release notes](https://github.com/TheXSolutions/badgify/blob/main/RELEASENOTES.md).

## Issues
If you encounter a bug or vulnerability, please read the [issue policy](https://github.com/TheXSolutions/badgify/blob/main/ISSUES.md).

## Documentation
To learn how to work with badgify, please take a look at the [/docs](https://github.com/TheXSolutions/badgify/tree/main/docs) folder.

## Acknowledgement
A great thanks to [@sarahrajabi](https://github.com/sarahrajabi) for designing the icon.


Made with Love and Java=))