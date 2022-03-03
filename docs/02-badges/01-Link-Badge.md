# Link Badge

link badges are badges with two part, one logo and one title. they are used as a link to a social media or anything
else.

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=purple)

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=yellow&size=m)

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=blue&size=l)

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=green&size=l)

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=pink&size=m)

![](https://repo-reporter.thex.solutions/api/badge/link?title=GitHub&logo=github&bg=red)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=lavender&dir=rtl)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=brown&size=m&dir=rtl)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=gray&size=l&dir=rtl)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=orange&size=l&dir=rtl)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=cyan&size=m&dir=rtl)

![](https://repo-reporter.thex.solutions/api/badge/link?title=گیتهاب&logo=github&bg=white&dir=rtl)

## Path

**`repo-reporter.thex.solutions/api/badge/link`**

## Inline

`repo-reporter.thex.solutions/api/badge/inline/link/<DIRCTION>-<SIZE>-<THEME>-<TITLE>-<LOGO>-<BG>-<COLOR>-<LINK>`

## Short Inline

`repo-reporter.thex.solutions/api/badge/inline/short/link/<TITLE>-<LOGO>-<BG>-<SIZE>`

## Parameters

title: **`string`** - the title of the badge (required)

logo: **`string`** - the logo of the badge (required)

theme: **`string`** - the theme of the badge (default: `simple`)

size: **`string`** - the size of the badge (default: `s`) - `s` for small, `m` for medium, `l` for large

dir: **`string`** - the direction of the badge (default: `ltr`) - `ltr` for left to right, `rtl` for right to left

link: **`string`** - the link of the badge (default: `#`)

bg: **`string`** - the background color of the badge (default: `transparent`) ex: `#ffffff` / `rgb(255,255,255)`

color: **`string`** - the text color of the badge (default: `#ffffff`) ex: `#ffffff` / `rgb(255,255,255)`