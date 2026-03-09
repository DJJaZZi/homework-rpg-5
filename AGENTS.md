# Repository Guidelines

## Project Structure & Module Organization
This repository is a self-contained Java starter project for Homework RPG 5. Source files live under `src/com/narxoz/rpg/`. Keep pattern code in its existing packages: `decorator/`, `facade/`, `hero/`, `enemy/`, and `hints/`. Root documentation includes `README.md`, `ASSIGNMENT.md`, `QUICKSTART.md`, `FAQ.md`, and `STUDENT_CHECKLIST.md`. Build output goes to `out/`; treat it as generated content, not source.

## Build, Test, and Development Commands
Run commands from the repository root:
- `javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })` compiles all Java sources into `out/`.
- `java -cp out com.narxoz.rpg.Main` runs the console demo.
- `git status --short` checks local changes before committing.

There is no Gradle or Maven build here; use the direct `javac` and `java` commands above.

## Coding Style & Naming Conventions
Use Java 17 style and keep formatting consistent with the current files:
- 4 spaces for indentation, no tabs.
- Package root stays `com.narxoz.rpg`.
- Classes and interfaces use `PascalCase`.
- Methods and fields use `camelCase`.
- Constants use `UPPER_SNAKE_CASE`.

Prefer small classes with one clear responsibility. Keep design-pattern roles explicit, and preserve instructional `TODO` markers unless the assignment itself is being changed.

## Testing Guidelines
There is no dedicated test framework configured yet. Minimum verification is:
- compile the project successfully
- run `Main` without runtime errors

If tests are added later, place them in a standard Java test tree and name them `<ClassName>Test`.

## Commit & Pull Request Guidelines
This repository has no commit history yet, so use a simple default format: `type(scope): summary`, for example `docs(repo): add contributor guide`. Keep commits focused and buildable.

Pull requests should include:
- a short description of what changed and why
- affected packages or docs
- the commands run to verify the change

## Contributor Notes
Do not commit generated files from `out/`. When changing assignment requirements or package structure, update the matching root docs so the scaffold and instructions stay aligned.
