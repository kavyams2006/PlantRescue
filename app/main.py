from fastapi import FastAPI

app = FastAPI(
    title="PlantRescue",
    description="AI-powered Plant Disease Detection and Treatment Recommendation System",
    version="1.0.0"
)

@app.get("/")
def home():
    return {
        "message": "Welcome to PlantRescue!",
        "project": "Plant Disease Detection and Treatment Recommendation System",
        "status": "Running"
    }

@app.get("/health")
def health_check():
    return {
        "status": "healthy"
    }