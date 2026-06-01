# Car Matchmaker

**CarDekho Group — Take-Home Assignment (Software Engineer, AI-Native)**

A full-stack web app that helps confused car buyers go from *“I don’t know what to buy”* to *“I’m confident about my shortlist”* — by answering two questions (budget + top priority) and surfacing a ranked **top 3** with clear reasons on each card.

**Repository:** [https://github.com/Harshita9v9/car-matchmaker](https://github.com/Harshita9v9/car-matchmaker)

| Deliverable | Status |
|-------------|--------|
| GitHub repo | Above link |
| Run instructions | See **Quick start** below (`docker compose up` — under 2 minutes, no Java required) |
| Live URL | *[Add if deployed to Railway / Render / etc.]* |
| Screen recording | *[Add Loom / Drive / YouTube (unlisted) link — mandatory per brief]* |

---

## Quick start (single-command local setup)

Per the assignment: reviewers must be able to run the app in **under 2 minutes** without installing Java.

**Prerequisites:** [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.

From the project root:

```bash
docker compose up --build
```

Open **http://localhost:8080** in your browser.

To run in the background:

```bash
docker compose up --build -d
```

To stop:

```bash
docker compose down
```

---

## Local development (optional)

Requires **JDK 17+**.

**Windows:**

```cmd
run.cmd
```

**Any OS:**

```bash
./mvnw spring-boot:run
```

Then visit **http://localhost:8080**.

---

## How it works

1. Enter **maximum budget (₹)** and what matters most: **Safety First** or **Fuel Efficiency**.
2. Backend filters cars within budget, sorts by your priority (`safetyRating` or `mileage` descending), returns **top 3**.
3. Results page shows make/model, price, mileage, safety (out of 5), category, and a highlighted review — so the buyer understands *why* each pick fits.

Dataset: 15 Indian-market cars (hardcoded at startup from the provided JSON spec).

---

## Assignment README (required answers)

*These sections directly answer the four required questions from the **CarDekho Group — Software Engineer (AI-Native) take-home brief**.*

### 1. What did you build and why? What did you deliberately cut?

**Built:** A **Car Matchmaker** wizard — a tight, opinionated MVP aligned with the brief: too many options, no easy way to choose. The app **reduces cognitive load** by asking only for **budget** and **one priority**, then returning a **confident shortlist of three** cars with spec summaries and review blurbs. The goal is progress in one session: confused → shortlist, not a full research portal.

**Deliberately cut:**

- **Real database (MySQL / PostgreSQL)** — inventory lives in memory (`@PostConstruct`) so reviewers get zero DB setup and the backend still does non-trivial **filter + sort + rank** work.
- **User authentication** — anonymous, one-shot flow; no accounts or saved sessions.
- **Variant-level catalog, compare tables, admin CMS, tests suite** — out of scope for a **2–3 hour** build window; would dilute the core “shortlist in seconds” story.

I’d rather ship a **tight, opinionated MVP** that actually helps a confused buyer than a half-finished kitchen sink (per the brief’s evaluation criteria).

### 2. What's your tech stack and why did you pick it?

| Layer | Choice |
|--------|--------|
| Language | **Java 17** |
| Framework | **Spring Boot 3** (Web + Thymeleaf) |
| UI | **Thymeleaf** + **Tailwind CSS** (CDN) |
| Build | **Maven** (`mvnw`) |
| Deploy / local | **Docker** (Eclipse Temurin 17) + **Docker Compose** |

**Why:** **Java + Spring Boot** for fast, readable backend logic (MVC, dependency injection, recommendation service). **Thymeleaf** keeps frontend and backend in one repo — **no separate SPA or REST contract** for a simple form → results flow, so **zero frontend connection overhead**. **Tailwind via CDN** gives a responsive, modern UI without a Node build step. **Docker Compose** meets the hard constraint: **single-command** runnable app for anyone reviewing the repo.

The brief does not mandate a specific framework; this stack optimizes **shipping speed** and **end-to-end “it works.”**

### 3. What did you delegate to AI tools vs. do manually? Where did they help most / get in the way?

*Complete the checkboxes and notes from your screen recording session.*

**Delegated to AI (Cursor):**

- [ ] Spring Boot structure: `Car` model, `CarService` (`getRecommendations`), `CarController`
- [ ] Hardcoding 15-car JSON dataset in `@PostConstruct`
- [ ] Thymeleaf pages (`index.html`, `results.html`) with Tailwind styling
- [ ] `Dockerfile`, `compose.yaml`, `.dockerignore`
- [ ] Initial `README.md` draft aligned to assignment questions

**Done manually:**

- [ ] Scoping: wizard vs. full catalog; two priorities only; top 3 only
- [ ] Browser testing: budget filter, safety vs. mileage sort order
- [ ] Git setup, commit, push to GitHub
- [ ] *[Anything you edited or rejected from AI output]*

**Where AI helped most:**

- [ ] *e.g. Boilerplate velocity, Docker multi-stage pattern, consistent UI layout*

**Where AI got in the way:**

- [ ] *e.g. Git push auth, environment-specific fixes, over-scoped suggestions*

**Process note (brief):** Screen recording should show prompting, review/course-correction, and when you stopped using the tool and typed code yourself — that transparency is what CarDekho evaluates under **agentic tool usage (30%)**.

### 4. If you had another 4 hours, what would you add?

1. **LLM integration** — personalized “why this car for *you*” summaries based on budget + priority (beyond static review strings).
2. **Cloud database** — move from in-memory JSON to **PostgreSQL** (or similar) with real inventory and optional admin updates.
3. **Deploy live** (Railway / Render / Fly.io) so reviewers have a URL, not only Docker.
4. *(Stretch)* Lightweight integration tests for `getRecommendations` and a health check in Compose.

---

## How this maps to the assignment constraints

| Constraint | How this repo meets it |
|------------|-------------------------|
| Working web app | Spring Boot app + Thymeleaf UI |
| Run in under 2 min | `docker compose up --build` → http://localhost:8080 |
| Full-stack | Interactive frontend + backend filter/sort/rank logic |
| Screen recording | *[Your link]* — terminal, editor, browser; unedited or lightly fast-forwarded |
| Time-box (2–3 h build) | Scoped MVP; see cuts above |

**Evaluation alignment (from brief):** Product decisions (tight shortlist wizard), agentic usage (recording + honest AI section above), sensible layered code (`model` / `service` / `controller`), execution speed (Docker one-liner, working E2E flow).

---

## Project structure

```
src/main/java/com/harshita/carmatchmaker/
├── CarMatchmakerApplication.java
├── controller/CarController.java
├── model/Car.java
└── service/CarService.java

src/main/resources/templates/
├── index.html      # Budget + priority form
└── results.html    # Top 3 shortlist cards

Dockerfile          # Multi-stage build (Eclipse Temurin 17)
compose.yaml        # docker compose up
```

---

## Submission checklist

Before sending to CarDekho Group, confirm:

- [ ] **Screen recording** link (most important deliverable)
- [ ] **GitHub repo** link (public or invite)
- [ ] **Live URL** *or* clear run instructions (this README + Docker)
- [ ] README answers all four questions (sections above)
