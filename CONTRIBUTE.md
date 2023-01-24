# Contribution

if you want to contribute to the badgify project, this contributing guide is helpful.

## Badge Themes

If you are good at working with SVGs, please help us to extend our theme library. You can join our discord server to discuss more about ideas.

[![](https://badgify.thex.solutions/api/badge/link?title=TheX's%20server&icon=discord&bg=5858be)](https://discord.gg/u3SsX89J) [![](https://badgify.thex.solutions/api/badge/link?title=TheX's%20group&icon=telegram&bg=1e869e)](https://t.me/TheXSolutions)

## Translate Documents In Your Language

If badgify's documentation has not been translated into your language, you can do this to help us provide better services to your compatriots.

## start contributing

We use GitFlow for branching model on this project. You must have [git-flow](https://github.com/nvie/gitflow/wiki/Installation) installed on your machine.

To start contributing on badgify:
- Fork badgify's repo
- Clone your fork
- Start your feature branch by `git flow feature start <feature_name>` command
- Create your changes and commits
- Push your feature branch
- Create pull request

```bash
git clone <your-fork-repo-url>
cd badgify
git flow feature start <feature_name>
// Create your changes and commits
git push origin feature/<feature_name>
```
and then make pull request.

### Idea
if you haven't any idea for contributing, you can see [Issues](https://github.com/TheXSolutions/badgify/issues) or [TODO.md](https://github.com/TheXSolutions/badgify/blob/main/TODO.md).

## Documentation
If you are adding/changing a feature, add/change documentation of that feature.

For example, If you are adding a new feature, add documentation for that in `doc/<Directory To That Feature>/<x>.md`.

## Release Notes
Write your changes into the [RELEASE-NOTES.md](https://github.com/TheXSolutions/badgify/blob/main/RELEASE-NOTES.md) file.

For example:

```bash
## next release
- ... (Someone's name)
- ... (Someone's name)
- Fixed bug X (Your name)
- Added X (Your name)
```
