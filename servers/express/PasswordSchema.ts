import mongoose from 'mongoose';

const UserSchema = new mongoose.Schema({
    userId: {
        type: String,
        required: true,
        unique: true
    },

    username: {
        type: String,
        required: true
    },

    password: {
        type: String,
        required: true
    },

    events: {
        type: [
            {
                name: {
                    type: String,
                    required: true
                },

                date: {
                    type: Date,
                    required: true
                },

                description: {
                    type: String,
                    required: false
                }
            }
        ],

        required: true
    },

    saved_passwords: {
        type: [
            {
                username: {
                    type: String,
                    required: false
                },

                password: {
                    type: String,
                    required: true
                },

                company: {
                    type: {
                        imageUrl: {
                            type: String,
                            required: true
                        },
                        name: {
                            type: String,
                            required: true
                        }
                    },
                    required: true
                }
            }
        ],

        required: true
    }
});

export default mongoose.model('UserSchema', UserSchema);
