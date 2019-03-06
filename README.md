Voice authentication using short phrases and sentences

Introduction

Many of transactions, such as those from mobile banking applications, require user verification.
The ability to establish a user's identity is a critical aspect of security engineering; thus the use of biometrics is increasingly popular as a means of verification
Much work has been done with verification using face, fingerprint and iris biometrics.
May be used for call center authentication.

Motivation

Creating an alternative authentication for mobile devices
Single sentence authentication based call center solutions
Use different sentences for different users
Create a local language solution for authentication

Speaker Verification

Voice has unique characteristics that can be used to identify a person, just like a fingerprint.
Using voice a new innovative tool –essentially offering a level up in security that simplifies the authentication experience for customers.
Enrollment for speaker verification is text-dependent, which means speakers need to choose a specific pass phrase to use during both enrollment and verification phases.
A number of features are extracted and the chosen phrase is recognized. Together, both extracted features and the chosen phrase form a unique voice signature

Speaker Identification

Identify the person speaking in an audio file, given a group of prospective speakers.
The input audio is paired against the provided group of speakers, and in the case that there is a match found, the speaker’s identity is returned.
All speakers should go through an enrollment process first to get their voice registered to the system, and have a voice print created.
Identification is text-independent
The input voice is compared against all speakers in order to determine whose voice it is, and if there is a match found, the identity of the speaker is returned.

Method

Only a simple console application is implemented
Microsoft Azure Speaker Recognition API have been used
Verification method has been selected
Validation method is supported, but API able to validate only 10 person
Turkish language is not supported
Limited authentication sentences are available
Login, New User and All User features added

