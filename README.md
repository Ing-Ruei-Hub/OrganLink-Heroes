# OrganLink-Heroes Project

## Project Overview
OrganLink-Heroes is a comprehensive organ donation and transplantation management system. It aims to streamline the process from donor/recipient registration to organ matching, logistics, and post-operative care, facilitating efficient and life-saving organ transplants.

## Purpose and Goal
The primary goal of OrganLink-Heroes is to create a robust, user-friendly, and secure platform that connects potential organ donors with recipients. It addresses the complexities of organ transplantation by providing dedicated workflows for various stakeholders, ensuring transparency, accuracy, and timely coordination.

## Technology Stack
*   **Language:** Java (JDK 19)
*   **IDE:** Apache NetBeans
*   **Build Tool:** Apache Ant
*   **Database:** db4o (Object-Oriented Database)
*   **GUI Framework:** Swing

## Project Structure
The project follows a typical NetBeans Java SE project structure:

*   `src/`: Contains all source code.
    *   `Business/`: Core business logic, entities, and system management.
        *   `DB4OUtil/`: Utility for db4o database operations.
        *   `Donor/`: Contains the `Donor` entity class.
        *   `Recipient/`: Contains the `Recipient` entity class.
        *   `Employee/`: Employee-related classes.
        *   `Enterprise/`: Enterprise (Hospital, Government, etc.) definitions.
        *   `Network/`: Network definitions.
        *   `Organization/`: Organization (Doctor, Lab, Admin, etc.) definitions.
        *   `Role/`: User roles (AdminRole, DoctorRole, etc.).
        *   `UserAccount/`: User account management.
        *   `WorkQueue/`: Core Work Request System (`WorkRequest`, `WorkQueue`, and specific `WorkRequest` subclasses).
        *   `Medical/`: Contains `MedicalTestResult` entity.
        *   `Logistics/`: Contains `TransportVehicle` and `LogisticsTeam` entities.
        *   `Util/`: Contains utility classes like `QueryService`.
    *   `userinterface/`: All GUI panels and the main application frame.
*   `lib/`: External JAR libraries.
*   `nbproject/`: NetBeans project configuration files (`project.properties`, `project.xml`, etc.).
*   `build/`: Compiled classes and build artifacts.
*   `dist/`: Distribution JAR.

## Key Features & Designed Workflows
The project is being developed to support the following cross-entity workflows:

1.  **Donor Registration and Initial Approval:** Donors register, Hospital Officers review and approve/reject.
2.  **Recipient Organ Request and Initial Matching:** Recipients register organ needs, Transplant Coordinators review, and initial donor matching is performed.
3.  **Medical Test Result Upload and Verification:** Lab Technicians upload test results, Doctors verify them.
4.  **Organ Logistics Request and Assignment:** Transplant Coordinators request organ transport, Logistics Officers assign resources.
5.  **Emergency Protocol Activation and Government Oversight:** Doctors activate emergency protocols, Government Officials approve/reject, System Admin oversees.
6.  **International Collaboration Request:** Transplant Coordinators request international matching, International Officers process.

## Foundational Elements Implemented
To support the above workflows and facilitate team collaboration, the following foundational elements have been implemented:

*   **Generic Work Request System:**
    *   `Business.WorkQueue.WorkRequest` (abstract base class)
    *   `Business.WorkQueue.WorkQueue`
    *   Specific `WorkRequest` subclasses for each workflow (`DonorRegistrationRequest`, `RecipientOrganRequest`, `MedicalTestWorkRequest`, `OrganTransportRequest`, `EmergencyProtocolRequest`, `InternationalCollaborationRequest`).
    *   `WorkQueue` has been integrated into the `Business.Organization.Organization` class to allow organizations to manage requests.
*   **Core Entity Model Classes:**
    *   `Business.Donor.Donor`: Class to represent organ donors.
    *   `Business.Recipient.Recipient`: Class to represent organ recipients.
    *   `Business.Medical.MedicalTestResult`: Class to store medical test details.
    *   `Business.Logistics.TransportVehicle`: Class to manage transport vehicles.
    *   `Business.Logistics.LogisticsTeam`: Class to manage logistics teams.
*   **Cross-Hierarchy Query Utilities:**
    *   `Business.Util.QueryService`: Provides static methods to query WorkRequests across the `EcoSystem` hierarchy. (Donor/Recipient query methods are placeholders and will require refinement once their storage is fully integrated).

## Setup Instructions

1.  **Clone the Repository:**
    `git clone <repository_url>`
    `cd OrganLink-Heros-Final`
2.  **Open in NetBeans:**
    *   Launch NetBeans IDE.
    *   Go to `File > Open Project...` and select the `OrganLink-Heros-Final` directory.
3.  **JDK Configuration:**
    *   Ensure your NetBeans project is configured to use **JDK 19**. Go to `Project Properties > Libraries > Java Platform`.
4.  **External Libraries:**
    *   Download `snakeyaml-1.23.jar` from [Maven Central](https://repo1.maven.org/maven2/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar) and place it in the `lib/` directory.
    *   Download `commons-lang3-3.12.0.jar` from [Maven Central](https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar) and place it in the `lib/` directory.
    *   **Crucially:** Ensure these are the actual JAR files, not the placeholder text files that were temporarily created during initial setup.
5.  **Project Properties (`nbproject/project.properties`) - Already Applied:**
    *   `main.class=userinterface.MainJFrame`
    *   `file.reference.db4o-core-8.0.249.16098.jar=lib/db4o-8.0.184.15484-all-java5.jar`
    *   Corrected circular classpath definitions for `javac.classpath` and `run.classpath`.
    *   `run.jvmargs=--add-opens java.base/java.util=ALL-UNNAMED` (for db4o compatibility with JDK 19).
    *   `snakeyaml-1.23.jar` and `commons-lang3-3.12.0.jar` added to classpath.

## Team Structure & Workflow Allocation

The project is divided into four teams, each with primary responsibilities for specific workflows and components:

*   **Team A: Donor & Recipient Onboarding**
    *   **Workflows:** Donor Registration and Initial Approval (Primary), Recipient Organ Request (Primary - Registration UI).
    *   **Focus:** UI for donor/recipient registration, initial data validation, user account management for these roles.

*   **Team B: Organ Matching & Pre-Coordination**
    *   **Workflows:** Recipient Organ Request (Primary - Matching Algorithm logic), Organ Logistics Request and Assignment (Primary - Logistics Request initiation & Assignment).
    *   **Focus:** Core matching logic, UI for Transplant Coordinators and related initial processing roles.

*   **Team C: Medical Logistics & Oversight**
    *   **Workflows:** Medical Test Result Upload and Verification (Primary), Emergency Protocol Activation (Primary - Doctor activation).
    *   **Focus:** Managing medical test results, logistics for organ transport, medical professional interfaces.

*   **Team D: System Admin & Critical Operations**
    *   **Workflows:** Donor Registration (Secondary - System Admin oversight), Emergency Protocol Activation (Primary - Government approval & System Admin oversight), International Collaboration Request (Primary).
    *   **Focus:** System-wide administration, critical approvals, external interfaces.

## Troubleshooting Common Issues

*   **"Initializing project..." hang in NetBeans:**
    *   Ensure `main.class` is correctly set in `nbproject/project.properties`.
    *   Ensure all necessary JARs (`snakeyaml`, `commons-lang3`, `db4o`) are present in `lib/` and referenced in `nbproject/project.properties`.
    *   Clear NetBeans cache (`Help > About > Cache Directory`, then delete contents with NetBeans closed).
    *   Restart NetBeans, or even your system if file locks persist.
*   **`java.lang.ClassNotFoundException` or `java.lang.NoClassDefFoundError`:**
    *   Verify that the required JAR file is present in the `lib/` directory.
    *   Ensure the JAR is correctly referenced in `nbproject/project.properties` (under `file.reference` and included in `javac.classpath`/`run.classpath`).
    *   Make sure you downloaded the *actual* JAR file and not a placeholder.
*   **`java.lang.IllegalArgumentException: Properties mapping could not be computed (e.g. due to a circular definition)`:**
    *   This was resolved by fixing circular references in `javac.classpath` and `run.classpath` in `nbproject/project.properties`. If it reappears, check for similar property definitions.
*   **`java.lang.RuntimeException: Failed to create DB4O connection` / `DatabaseFileLockedException`:**
    *   Ensure no other instance of the application is running.
    *   Restart NetBeans.
    *   Restart your computer if the file lock persists.
*   **`java.lang.reflect.InaccessibleObjectException`:**
    *   This was resolved by adding `--add-opens java.base/java.util=ALL-UNNAMED` to `run.jvmargs` in `nbproject/project.properties` for db4o compatibility with newer JDKs.
*   **`java.lang.NullPointerException` in `ConfigureASystem.configure`:**
    *   This was resolved by adding the missing `Admin` organization creation case in `Business.Organization.OrganizationDirectory.java`. Review `ConfigureASystem.java` logic if similar issues arise for other organizations.

---
_This README provides a comprehensive overview of the OrganLink-Heroes project and its current development status._
