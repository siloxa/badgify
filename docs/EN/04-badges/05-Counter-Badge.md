# Counter Badge
This type of badges, count a number when they called. They can be used for profile and repository view counters because when someone visits your profile or repository it will be counted up.

GitHub Profile:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros)

GitLab Profile:

```md
badgify.thex.solutions/api/counter/gitlab/profile/<YOUR-GITLAB-ACCOUNT-ID>
```

![](https://badgify.thex.solutions/api/counter/gitlab/profile/shuoros)

GitHub Repository

```md
badgify.thex.solutions/api/counter/github/repo/<YOUR-GITHUB-ACCOUNT-ID>/<YOUR-REPOSITORY>
```

![](https://badgify.thex.solutions/api/counter/github/repo/shuoros/badgify)

GitLab Repository

```md
badgify.thex.solutions/api/counter/gitlab/repo/<YOUR-GITLAB-ACCOUNT-ID>/<YOUR-REPOSITORY>
```

![](https://badgify.thex.solutions/api/counter/gitlab/repo/shuoros/badgify)

Change the title as you wish:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>?title=Soroush's%20Profile%20Views
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros?title=Soroush's%20Profile%20Views)

Count views of your GitHub Repository:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros)

Change the background color as you wish:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>?bg=lavender
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros?bg=lavender)

Change the title color as you wish:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>?color=green
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros?color=green)

Change the Size of badge as you wish:

```md
badgify.thex.solutions/api/counter/github/profile/<YOUR-GITHUB-ACCOUNT-ID>?size=m
```

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros)

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros?size=m)

![](https://badgify.thex.solutions/api/counter/github/profile/shuoros?size=l)

## Paths

**`badgify.thex.solutions/api/counter`**

## Path Variables

```
badgify.thex.solutions/api/counter/<VSC>/profile/<YOUR-ACCOUNT-ID>
```

VSC : **`string`** - github or gitlab (required)

YOUR-ACCOUNT-ID : **`string`** - your github or gitlab account id (required)

```
badgify.thex.solutions/api/counter/<VSC>/repo/<YOUR-ACCOUNT-ID>/<YOUR-REPO>
```

VSC : **`string`** - github or gitlab (required)

YOUR-ACCOUNT-ID : **`string`** - your github or gitlab account id (required)

YOUR-REPO : **`string`** - your github or gitlab account id (required)

## Parameters

title: **`string`** - the title of the badge (required)

theme: **`string`** - the theme of the badge (default: `simple`)

size: **`string`** - the size of the badge (default: `s`) - `s` for small, `m` for medium, `l` for large

link: **`string`** - the link of the badge (default: `based on your social will be generated`)

bg: **`string`** - the background color of the badge (default: `transparent`) ex: `#ffffff` / `rgb(255,255,255)`

color: **`string`** - the text color of the badge (default: `#ffffff`) ex: `#ffffff` / `rgb(255,255,255)`
